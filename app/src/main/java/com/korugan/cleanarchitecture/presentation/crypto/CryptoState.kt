package com.korugan.cleanarchitecture.presentation.crypto

import com.korugan.cleanarchitecture.domain.model.Crypto

data class CryptoState(
    val isLoading:Boolean = false,
    val crypto: List<Crypto> = emptyList(),
    val error:String =""
)