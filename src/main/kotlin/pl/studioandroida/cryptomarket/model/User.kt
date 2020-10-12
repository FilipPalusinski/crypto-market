package pl.studioandroida.cryptomarket.model

import org.hibernate.annotations.Cascade
import org.hibernate.annotations.CascadeType
import javax.persistence.*

@Entity
data class User(
        @Id @GeneratedValue val id: Long = 0,
        val firstName: String = "",
        val lastName: String = "",
        @OneToOne @Cascade(CascadeType.ALL) val wallet: Wallet = Wallet()
)