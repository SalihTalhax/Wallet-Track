package com.info.wallet_track_app.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Solana {
    @SerializedName("solana")
    @Expose
    var solana: Bitcoin? = null
}