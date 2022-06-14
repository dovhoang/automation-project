package viet.hoang.automationproject.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET
import viet.hoang.automationproject.models.ResultHistory

interface APIService {
    @get:GET("/api/users/2")
    val getNewRecord : Call<ResultHistory>
}

interface IDataResultCallback<T> {
    fun onReceive(success: Boolean, data: T?)
}

object APIHandler{
    private val STATUS_CODE_SUCCESS = 200;

    fun getNewRecord(callback : IDataResultCallback<ResultHistory>) {
        API.apiService.getNewRecord.enqueue(object : Callback<ResultHistory>{
            override fun onResponse(call: Call<ResultHistory>, response: Response<ResultHistory>) {
                if (response.code() == STATUS_CODE_SUCCESS){
                    var data = response.body()
                    if (data!= null){
                        callback.onReceive(true, data)
                    }
                }else{
                    callback.onReceive(false, null)
                }
            }

            override fun onFailure(call: Call<ResultHistory>, t: Throwable) {
                callback.onReceive(false, null)
            }
        })
    }
}
