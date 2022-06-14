package viet.hoang.automationproject.ui.control

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import viet.hoang.automationproject.models.ResultHistory
import viet.hoang.automationproject.network.APIHandler
import viet.hoang.automationproject.network.IDataResultCallback
import java.time.LocalDateTime
import java.util.*

class ControlViewModel : ViewModel() {

    private val _histories = MutableLiveData<List<ResultHistory>>().apply {
        value = listOf(ResultHistory(Calendar.getInstance().time,"121212","122324"))
    }
    val histories: LiveData<List<ResultHistory>> = _histories

    private val _nsx = MutableLiveData<String>()
    val nsx: LiveData<String> = _nsx

    private val _hsd = MutableLiveData<String>();
    val hsd: LiveData<String> = _hsd

    fun add(nsx : String, hsd : String ){
        _histories.value = _histories.value?.plus(ResultHistory(Calendar.getInstance().time, nsx, hsd))
    }

    fun getData(){
//        APIHandler.getNewRecord(object : IDataResultCallback<ResultHistory>{
//            override fun onReceive(success: Boolean, data: ResultHistory?) {
//                if (success && data != null){
//                    _nsx.value = data.nsx
//                    _hsd.value = data.hsd
//                    val data = ResultHistory(Calendar.getInstance().time, data.nsx, data.hsd)
//                    add(data.nsx, data.hsd)
//                }
//            }
//
//        })

        var hsd = (100000..999999).random().toString()
        var nsx = (100000..999999).random().toString()

        _nsx.value = nsx
        _hsd.value = hsd
        val data = ResultHistory(Calendar.getInstance().time, nsx,hsd)
        add(data.nsx, data.hsd)
    }
}
