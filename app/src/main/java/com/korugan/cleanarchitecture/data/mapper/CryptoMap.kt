package com.korugan.cleanarchitecture.data.mapper

import com.korugan.cleanarchitecture.data.remote.dto.CryptoDto
import com.korugan.cleanarchitecture.domain.model.Crypto

fun CryptoDto.toCrypto(): List<Crypto> {
    return result.map {
        Crypto(
            code = it.code,
            pricestr = it.pricestr,
            currency = it.currency
        )
    }
}