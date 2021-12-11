package com.example.coronavs.ui.splash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.coronavs.utiles.bases.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel  @Inject constructor(): BaseViewModel() {

    private val _isTimerFinished = MutableLiveData(false)
    val isTimerFinished: MutableLiveData<Boolean>
        get() = _isTimerFinished

    init {
        startTimer()
    }

    private fun startTimer(){

        viewModelScope.launch {
            delay(3000)

            _isTimerFinished.value = true
        }
    }
}