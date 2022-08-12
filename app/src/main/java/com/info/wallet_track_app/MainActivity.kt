package com.info.wallet_track_app

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
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
    private var cryptoList = ArrayList<Coin>()
    private lateinit var adapter: RVAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myRecy = findViewById<RecyclerView>(R.id.Recy)

        myRecy.setHasFixedSize(true)

        // RecyclerView'ın ekranda nasıl bir yapısı olacagını belirledigimiz property
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        myRecy.layoutManager = layoutManager

        // Ekrana verilerin doğru şekilde girilmesini saplayan sınıf
        adapter = RVAdapter(this)
        myRecy.adapter = adapter


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
                val crypto = response.body()

                cryptoList.add(Coin("cake", crypto!!.cake!!.usd!!))
                cryptoList.add(Coin("eos", crypto.eos!!.usd!!))
                cryptoList.add(Coin("cardano", crypto.cardano!!.usd!!))
                cryptoList.add(Coin("near", crypto.near!!.usd!!))
                cryptoList.add(Coin("chainlink", crypto.chainlink!!.usd!!))
                cryptoList.add(Coin("bitcoin", crypto.bitcoin!!.usd!!))
                cryptoList.add(Coin("litecoin", crypto.litecoin!!.usd!!))
                cryptoList.add(Coin("monero", crypto.monero!!.usd!!))
                cryptoList.add(Coin("binancecoin", crypto.binancecoin!!.usd!!))
                cryptoList.add(Coin("stellar", crypto.stellar!!.usd!!))
                cryptoList.add(Coin("ripple", crypto.ripple!!.usd!!))
                cryptoList.add(Coin("ethereum", crypto.ethereum!!.usd!!))
                cryptoList.add(Coin("solana", crypto.solana!!.usd!!))
                cryptoList.add(Coin("algorand", crypto.algorand!!.usd!!))
                cryptoList.add(Coin("polkadot", crypto.polkadot!!.usd!!))
                cryptoList.add(Coin("uniswap", crypto.uniswap!!.usd!!))
                cryptoList.add(Coin("internet-computer", crypto.internetComputer!!.usd!!))
                cryptoList.add(Coin("tron", crypto.tron!!.usd!!))
                cryptoList.add(Coin("neutrino", crypto.neutrino!!.usd!!))
                cryptoList.add(Coin("celo", crypto.celo!!.usd!!))

                populateUI()
            }

            override fun onFailure(call: Call<CryptoPrice?>, t: Throwable) {
                Log.e("MainActivity", t.localizedMessage)
            }
        })
    }

    private fun populateUI() {
        // Verileri adaptöre ilet
        adapter.setData(cryptoList)
    }
}