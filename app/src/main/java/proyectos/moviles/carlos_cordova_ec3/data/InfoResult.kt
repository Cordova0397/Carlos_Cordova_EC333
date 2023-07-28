package proyectos.moviles.carlos_cordova_ec3.data

import proyectos.moviles.carlos_cordova_ec3.data.response.InfoListResponse
import java.lang.Exception

sealed class InfoResult<T>(data: T?=null,error: Exception?=null) {
    data class Success<T>(val data:T): InfoResult<T>(data,null)
    data class Error<T>(val error:Exception): InfoResult<T>(null,error)
}
