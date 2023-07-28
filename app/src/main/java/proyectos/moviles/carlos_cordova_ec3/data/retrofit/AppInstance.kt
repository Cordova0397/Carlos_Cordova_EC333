package proyectos.moviles.carlos_cordova_ec3.data.retrofit

import proyectos.moviles.carlos_cordova_ec3.data.response.InfoListResponse
import retrofit2.http.GET

interface AppInstance {
    @GET("")
    suspend fun getAllInfo(): InfoListResponse
}