package com.info.wallet_track_app.retrofit

import com.info.wallet_track_app.model.CryptoPrice
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface RetrofitApi {
    @GET("simple/price")
    fun getCryptoPrice(
        @QueryMap map: Map<String?, String?>?
    ): Call<CryptoPrice?>?

    @GET("coins/{coin_id}")
    fun getCoinDetails(@Path(value = "coin_id", encoded = true) coinId: String?): Call<>
}