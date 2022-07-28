package com.info.wallet_track_app.retrofit

import com.info.wallet_track_app.model.CryptoPrice
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface RetrofitApi {
    @GET("simple/price")
    fun getCryptoPrice(
        @QueryMap map: Map<String?, String?>?
    ): Call<CryptoPrice?>?
}