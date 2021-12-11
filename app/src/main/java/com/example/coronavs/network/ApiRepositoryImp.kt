package com.example.coronavs.network

import com.example.coronavs.network.erorhandling.Resource
import com.example.coronavs.network.erorhandling.ResponseHandler
import com.example.coronavs.network.datamodel.ResponseCorona
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class ApiRepositoryImp @Inject constructor(
    private val apiService: ApiService,
    private val responseHandler: ResponseHandler
) : ApiRepository {
    override suspend fun getCorona(): Resource<ResponseCorona> =
        withContext(Dispatchers.IO) {
            return@withContext try {
                val result = apiService.getCorona()
                responseHandler.handleSuccess(result)
            } catch (e: Exception) {
                responseHandler.handleException(e)
            }
        }
}
