package pl.studioandroida.cryptomarket.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import pl.studioandroida.cryptomarket.model.Wallet

@Repository
interface WalletRepository: JpaRepository<Wallet, Long> {
}