package proyectos.moviles.carlos_cordova_ec3.model

import com.google.gson.annotations.SerializedName

data class Info(
    val name: String,
    @SerializedName("img_url")
    val imgUrl: String = ""
)

fun getData(): List<Info> = listOf()
