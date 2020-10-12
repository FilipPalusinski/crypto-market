package pl.studioandroida.cryptomarket.model

import javax.persistence.*

@Entity
data class User(
        @Id @GeneratedValue val id: Long = 0,
        val firstName: String = "",
        val lastName: String = "",
        @OneToOne val wallet: Wallet = Wallet()
)