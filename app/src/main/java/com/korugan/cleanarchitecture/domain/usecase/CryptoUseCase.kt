package com.korugan.cleanarchitecture.domain.usecase

import com.korugan.cleanarchitecture.data.mapper.toCrypto
import com.korugan.cleanarchitecture.domain.model.Crypto
import com.korugan.cleanarchitecture.domain.repository.CryptoRepository
import com.korugan.cleanarchitecture.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class CryptoUseCase @Inject constructor(private val cryptoRepository: CryptoRepository) {
    fun getCrypto(): Flow<Resource<List<Crypto>>> = flow {
        try {
            emit(Resource.Loading())
            val crypto = cryptoRepository.getCrypto()
            if (crypto.success) {
                emit(Resource.Success(crypto.toCrypto()))
            } else {
                emit(Resource.Error("No Crypto Found"))
            }
        } catch (e: HttpException) {
            emit(Resource.Error("Error : ${e}"))
        } catch (e: IOException) {
            emit(Resource.Error("Error : ${e}"))
        }
    }
}