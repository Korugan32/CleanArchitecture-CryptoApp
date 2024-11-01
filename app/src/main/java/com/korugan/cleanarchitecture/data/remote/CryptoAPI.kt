package com.korugan.cleanarchitecture.data.remote

import com.korugan.cleanarchitecture.data.remote.dto.CryptoDto
import com.korugan.cleanarchitecture.util.Constants.API_KEY
import com.korugan.cleanarchitecture.util.Constants.CONTENT_TYPE
import retrofit2.http.GET
import retrofit2.http.Header

interface CryptoAPI {
    @GET("/economy/cripto")
    suspend fun getCrypto(
        @Header("content-type") type: String = CONTENT_TYPE,
        @Header("authorization") auth: String = API_KEY,
    ): CryptoDto
}