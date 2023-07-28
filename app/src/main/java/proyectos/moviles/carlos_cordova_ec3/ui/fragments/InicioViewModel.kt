package proyectos.moviles.carlos_cordova_ec3.ui.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import proyectos.moviles.carlos_cordova_ec3.data.InfoResult
import proyectos.moviles.carlos_cordova_ec3.data.repository.InfoRepository
import proyectos.moviles.carlos_cordova_ec3.model.Info
import proyectos.moviles.carlos_cordova_ec3.model.getData

class InicioViewModel: ViewModel() {
    val info: MutableLiveData<List<Info>> = MutableLiveData<List<Info>>()
    private val repository = InfoRepository()

    fun getInfo(){
        val allInfo = getData()
        info.value = allInfo
    }
    fun getInfoFromService(){
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getInfo()
            when(response){
                is InfoResult.Success -> {

                }
                is InfoResult.Error -> {

                }
            }
            //info.postValue(response)
        }
    }
}