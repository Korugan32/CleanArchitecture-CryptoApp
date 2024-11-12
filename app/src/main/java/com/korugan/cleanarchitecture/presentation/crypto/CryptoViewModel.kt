package com.korugan.cleanarchitecture.presentation.crypto

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.korugan.cleanarchitecture.domain.usecase.CryptoUseCase
import com.korugan.cleanarchitecture.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CryptoViewModel @Inject constructor(
    private val cryptoUseCase: CryptoUseCase
) : ViewModel() {

    private val _state = mutableStateOf(CryptoState())
    val state: State<CryptoState> = _state

    private var job: Job? = null

    init {
        getCrypto()
    }

    private fun getCrypto() {
        job?.cancel()

        job = cryptoUseCase.getCrypto().onEach {
            when (it) {
                is Resource.Success -> {
                    _state.value = _state.value.copy(
                        crypto = it.data ?: emptyList(),
                        isLoading = false
                    )
                }
                is Resource.Loading -> {
                    _state.value = _state.value.copy(
                        isLoading = true
                    )
                }
                is Resource.Error -> {
                    _state.value = _state.value.copy(
                        error = it.message ?: "Error",
                        isLoading = false
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}