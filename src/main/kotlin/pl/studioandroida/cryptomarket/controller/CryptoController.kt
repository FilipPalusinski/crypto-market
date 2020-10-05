package pl.studioandroida.cryptomarket.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import pl.studioandroida.cryptomarket.model.User
import pl.studioandroida.cryptomarket.repository.UserRepository
import pl.studioandroida.cryptomarket.repository.WalletRepository


@RestController
class CryptoController {

    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var walletRepository: WalletRepository

    @GetMapping("/user")
    fun getUsers(): List<User>{
        return userRepository.findAll()
    }


}