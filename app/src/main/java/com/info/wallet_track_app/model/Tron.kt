package com.info.wallet_track_app.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Tron {
    @SerializedName("tron")
    @Expose
    var tron: Bitcoin? = null
}