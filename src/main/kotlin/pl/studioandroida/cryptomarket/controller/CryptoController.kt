package pl.studioandroida.cryptomarket.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import pl.studioandroida.cryptomarket.CryptoFacade
import pl.studioandroida.cryptomarket.CryptoFacadeImpl
import pl.studioandroida.cryptomarket.exceptions.UserNotFoundException
import pl.studioandroida.cryptomarket.model.User
import pl.studioandroida.cryptomarket.model.Wallet
import pl.studioandroida.cryptomarket.repository.UserRepository
import pl.studioandroida.cryptomarket.repository.WalletRepository


@RestController
class CryptoController {

    @Autowired
    lateinit var cryptoFacade: CryptoFacade

    @GetMapping("/users")
    fun getUsers(): List<User>{
        return cryptoFacade.getUsers()
    }

    @PostMapping("/user")
    fun addUser(@RequestParam("firstName") firstName: String,
                @RequestParam("lastName") lastName: String): User{
        return cryptoFacade.addUser(firstName, lastName)
    }


    @GetMapping("/user/{id}")
    fun getUsers(@PathVariable id: Long): User{
        return cryptoFacade.getUser(id)
    }

    @PostMapping("/user/{id}/sell/btc")
    fun sellBtc(@PathVariable id:Long,
                @RequestParam("amount") amount: Double): Wallet{
        return cryptoFacade.sellBtc(id, amount)
    }
}