package pl.studioandroida.cryptomarket.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus


@ResponseStatus(HttpStatus.FORBIDDEN)
class NotEnoughMoneyException(msg: String): RuntimeException(msg) {
}