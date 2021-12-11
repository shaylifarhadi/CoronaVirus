package com.example.coronavs.network.erorhandling

data class Resource<out T>(val status: Status, val data: T?, val message: String?, val code: Int?) {
    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null, null)
        }

        fun <T> error(msg: String, data: T?, code: Int? = null): Resource<T> {
            return Resource(Status.ERROR, data, msg, code)
        }
    }
}
