package com.example.coronavs.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.coronavs.network.ApiRepository
import com.example.coronavs.network.datamodel.Country
import com.example.coronavs.network.datamodel.ResponseCorona
import com.example.coronavs.network.erorhandling.Resource
import com.example.coronavs.utiles.bases.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoronaViewModel @Inject constructor(private val apiRepository: ApiRepository) : BaseViewModel() {

    private val _responseCorona = MutableLiveData<Resource<ResponseCorona>>()
    val responseCorona: LiveData<Resource<ResponseCorona>>
        get() = _responseCorona

    lateinit var list :List<Country>

    init {
        getCoronaList()
    }

    private fun getCoronaList() {
        viewModelScope.launch {
            _responseCorona.value = apiRepository.getCorona()
        }

    }
}