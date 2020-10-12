package pl.studioandroida.cryptomarket.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import kotlin.RuntimeException

@ResponseStatus(HttpStatus.NOT_FOUND)
class UserNotFoundException(msg: String): RuntimeException(msg) {
}