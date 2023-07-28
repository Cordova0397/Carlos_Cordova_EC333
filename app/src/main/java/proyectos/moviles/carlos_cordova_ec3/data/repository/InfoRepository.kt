package proyectos.moviles.carlos_cordova_ec3.data.repository

import proyectos.moviles.carlos_cordova_ec3.data.InfoResult
import proyectos.moviles.carlos_cordova_ec3.data.response.InfoListResponse
import proyectos.moviles.carlos_cordova_ec3.data.retrofit.RetrofitHelper
import proyectos.moviles.carlos_cordova_ec3.model.Info

class InfoRepository {
    suspend fun getInfo(): InfoResult<InfoListResponse> {
        return try {
            val response = RetrofitHelper.appInstance.getAllInfo()
            return InfoResult.Success(response)
        }catch (e: Exception){
            return InfoResult.Error(e)
        }


    }
}