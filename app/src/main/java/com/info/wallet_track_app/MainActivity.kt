package com.info.wallet_track_app

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.info.wallet_track_app.model.CryptoPrice
import com.info.wallet_track_app.retrofit.RetrofitApi
import com.info.wallet_track_app.retrofit.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    private lateinit var retrofitInstance: Retrofit
    private lateinit var api: RetrofitApi
    private var crypto:CryptoPrice? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        retrofitInstance = RetrofitBuilder.getInstance()!!

        getCoinPrices()
    }

    private fun getCoinPrices() {
        api = retrofitInstance.create(RetrofitApi::class.java)

        val data: MutableMap<String?, String?> = HashMap()
        data["ids"] = "bitcoin,ethereum,binancecoin,near,ripple,chainlink," +
                "eos,tron,algorand,monero,litecoin,cardano,uniswap," +
                "stellar,polkadot,celo,solana,cake,internet-computer,neutrino"
        data["vs_currencies"] = "usd"

        api.getCryptoPrice(data)!!.enqueue(object : Callback<CryptoPrice?> {
            override fun onResponse(call: Call<CryptoPrice?>, response: Response<CryptoPrice?>) {
                crypto = response.body()
                populateUI()
            }

            override fun onFailure(call: Call<CryptoPrice?>, t: Throwable) {
                Log.e("MainActivity", t.localizedMessage)
            }
        })
    }

    private fun populateUI() {
        // TODO : Elindeki veriyi (crypto) ekrana aktar
    }
}