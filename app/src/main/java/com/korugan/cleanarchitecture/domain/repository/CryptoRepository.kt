package com.korugan.cleanarchitecture.domain.repository

import com.korugan.cleanarchitecture.data.remote.dto.CryptoDto

interface CryptoRepository {
    suspend fun getCrypto() : CryptoDto
}