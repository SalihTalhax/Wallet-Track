package com.info.wallet_track_app.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CryptoPrice {
    @SerializedName("cake")
    @Expose
    var cake: Bitcoin? = null

    @SerializedName("eos")
    @Expose
    var eos: Bitcoin? = null

    @SerializedName("cardano")
    @Expose
    var cardano: Bitcoin? = null

    @SerializedName("near")
    @Expose
    var near: Bitcoin? = null

    @SerializedName("chainlink")
    @Expose
    var chainlink: Bitcoin? = null

    @SerializedName("bitcoin")
    @Expose
    var bitcoin: Bitcoin? = null

    @SerializedName("litecoin")
    @Expose
    var litecoin: Bitcoin? = null

    @SerializedName("monero")
    @Expose
    var monero: Bitcoin? = null

    @SerializedName("binancecoin")
    @Expose
    var binancecoin: Bitcoin? = null

    @SerializedName("stellar")
    @Expose
    var stellar: Bitcoin? = null

    @SerializedName("ripple")
    @Expose
    var ripple: Bitcoin? = null

    @SerializedName("ethereum")
    @Expose
    var ethereum: Bitcoin? = null

    @SerializedName("solana")
    @Expose
    var solana: Bitcoin? = null

    @SerializedName("algorand")
    @Expose
    var algorand: Bitcoin? = null

    @SerializedName("polkadot")
    @Expose
    var polkadot: Bitcoin? = null

    @SerializedName("uniswap")
    @Expose
    var uniswap: Bitcoin? = null

    @SerializedName("internet-computer")
    @Expose
    var internetComputer: Bitcoin? = null

    @SerializedName("tron")
    @Expose
    var tron: Bitcoin? = null

    @SerializedName("neutrino")
    @Expose
    var neutrino: Bitcoin? = null

    @SerializedName("celo")
    @Expose
    var celo: Bitcoin? = null
}