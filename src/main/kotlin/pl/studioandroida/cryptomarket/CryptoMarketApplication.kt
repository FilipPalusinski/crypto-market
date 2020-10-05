package pl.studioandroida.cryptomarket

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class CryptoMarketApplication

fun main(args: Array<String>) {
    runApplication<CryptoMarketApplication>(*args)
}

    @RestController
    class HelloController{

        @GetMapping()
        fun getHello()= "Hello World"



}
