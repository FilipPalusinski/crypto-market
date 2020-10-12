package pl.studioandroida.cryptomarket

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import pl.studioandroida.cryptomarket.exceptions.NotEnoughMoneyException
import pl.studioandroida.cryptomarket.exceptions.UserNotFoundException
import pl.studioandroida.cryptomarket.model.User
import pl.studioandroida.cryptomarket.model.Wallet
import pl.studioandroida.cryptomarket.repository.UserRepository
import pl.studioandroida.cryptomarket.repository.WalletRepository

interface CryptoFacade {
    fun getUsers(): List<User>
    fun addUser(firstName: String, lastName: String): User
    fun getUser(id: Long): User
    fun sellBtc(id: Long, amount: Double): Wallet
}


@Service
class CryptoFacadeImpl: CryptoFacade {
    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var walletRepository: WalletRepository



    override fun getUsers(): List<User> {
        return userRepository.findAll()
    }
    override fun addUser(firstName: String, lastName: String): User{
        val wallet = Wallet(btc = 5.0, usd = 1250.0)
        walletRepository.save(wallet)

        val user = User(firstName = firstName, lastName = lastName, wallet = wallet)
        userRepository.save(user)

        return user
    }
    override fun getUser(id: Long): User{
        return userRepository
                .findById(id)
                .orElseThrow { throw UserNotFoundException("can't find user with such id") }
    }

    override fun sellBtc(id: Long, amount: Double): Wallet {
        val user = userRepository.getOne(id)
        val btcAmount = user.wallet.btc

        if(btcAmount >= amount){
            user.wallet.btc -= amount
            user.wallet.usd += amount * BTC_PRICE
            userRepository.save(user)
        }else{
            throw NotEnoughMoneyException("you have not enough bitcoins.")
        }
        return user.wallet
    }

    companion object{
        const val BTC_PRICE = 5000.0
    }

}