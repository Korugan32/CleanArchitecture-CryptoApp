package com.korugan.cleanarchitecture.data.repository

import com.korugan.cleanarchitecture.data.remote.CryptoAPI
import com.korugan.cleanarchitecture.data.remote.dto.CryptoDto
import com.korugan.cleanarchitecture.domain.repository.CryptoRepository
import javax.inject.Inject

class CryptoRepositoryImpl @Inject constructor(
    private val cryptoAPI: CryptoAPI
) : CryptoRepository {
    override suspend fun getCrypto(): CryptoDto {
        return cryptoAPI.getCrypto()
    }
}