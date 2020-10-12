package pl.studioandroida.cryptomarket.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Wallet(
        @Id @GeneratedValue val id: Long = 0,
        var btc: Double = 0.0,
        var usd: Double = 0.0
)

