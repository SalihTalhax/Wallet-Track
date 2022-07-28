package com.info.wallet_track_app.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {

    companion object {
        private var instance: Retrofit? = null
        fun getInstance(): Retrofit? {
            return if(instance != null) {
                instance
            } else {
                instance = Retrofit.Builder()
                    .baseUrl("https://api.coingecko.com/api/v3/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                instance
            }
        }
    }

}