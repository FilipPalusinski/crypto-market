package pl.studioandroida.cryptomarket.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import pl.studioandroida.cryptomarket.model.User

@Repository
interface UserRepository: JpaRepository<User, Long> {

}