package com.example.coronavs.network.erorhandling

import android.content.Context
import com.example.coronavs.R
import com.squareup.moshi.Moshi
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.HttpException
import timber.log.Timber
import java.net.ConnectException
import java.net.SocketTimeoutException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
open class ResponseHandler @Inject constructor(
    @ApplicationContext val context: Context,
    val moshi: Moshi,
) {

    fun <T> handleSuccess(data: T): Resource<T> {
        return Resource.success(data)
    }

    fun <T : Any> handleException(e: java.lang.Exception): Resource<T> {
        Timber.e(e)
        return when (e) {

            is HttpException -> {
                Resource.error(
                    getErrorMessage(e.code()),
                    null, code = e.code()
                )
            }
            is ConnectException -> {
                Resource.error(
                    context.getString(R.string.connection_error),
                    null, code = 504
                )
            }
            is SocketTimeoutException -> {
                Resource.error(context.getString(R.string.timeout), null, code = 504)
            }
            else -> Resource.error(context.getString(R.string.general_error), null)

        }
    }

    private fun getErrorMessage(code: Int): String {
        return when (code) {
            401 -> context.getString(R.string.token_expire_login_again)
            404 -> context.getString(R.string.not_found)
            else -> context.getString(R.string.general_error)
        }
    }

}
