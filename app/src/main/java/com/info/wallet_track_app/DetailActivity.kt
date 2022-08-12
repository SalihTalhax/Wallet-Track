package com.info.wallet_track_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.info.wallet_track_app.model.CryptoInfo
import com.info.wallet_track_app.model.CryptoPrice
import com.info.wallet_track_app.retrofit.RetrofitApi
import com.info.wallet_track_app.retrofit.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class DetailActivity : AppCompatActivity() {
    private var coinName: String? = ""
    private lateinit var retrofitInstance: Retrofit
    private lateinit var api: RetrofitApi
    private lateinit var descriptionView: TextView
    private var cryptoInfo : CryptoInfo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        if(intent.hasExtra("coinId")) {
            coinName = intent.getStringExtra("coinId")
        }

        retrofitInstance = RetrofitBuilder.getInstance()!!

        getCryptoDetail()
    }

    fun getCryptoDetail() {
        api = retrofitInstance.create(RetrofitApi::class.java)

        api.getCoinDetails("bitcoin").enqueue(object : Callback<CryptoInfo?> {
            override fun onResponse(call: Call<CryptoInfo?>, response: Response<CryptoInfo?>) {
                cryptoInfo = response.body()
                populateUI()
            }

            override fun onFailure(call: Call<CryptoInfo?>, t: Throwable) {
                Log.e("MainActivity", t.localizedMessage)
            }
        })
    }

    fun populateUI() {
        descriptionView = findViewById(R.id.descriptionView)

        descriptionView.text = cryptoInfo!!.description!!.en
    }
}