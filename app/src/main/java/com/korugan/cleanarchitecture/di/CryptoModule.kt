package com.korugan.cleanarchitecture.di

import com.korugan.cleanarchitecture.data.remote.CryptoAPI
import com.korugan.cleanarchitecture.data.repository.CryptoRepositoryImpl
import com.korugan.cleanarchitecture.domain.repository.CryptoRepository
import com.korugan.cleanarchitecture.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object CryptoModule {

    @Singleton
    @Provides
    fun provideApi(): CryptoAPI {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CryptoAPI::class.java)
    }

    @Singleton
    @Provides
    fun provideRepository(cryptoAPI: CryptoAPI): CryptoRepository {
        return CryptoRepositoryImpl(cryptoAPI)
    }
}