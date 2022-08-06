package com.info.wallet_track_app.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Polkadot {
    @SerializedName("polkadot")
    @Expose
    var polkadot: Bitcoin? = null
}