package id.co.instansiindonesia.instansiindonesia.api

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET
    fun view(@Url url: String): Call<ResponeInstansi>

    companion object {
        fun create(): APIService {
            val retrofit = Retrofit.Builder()
                    .baseUrl("http://dev.farizdotid.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            return retrofit.create(APIService::class.java)
        }
    }
}