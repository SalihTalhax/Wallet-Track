package com.info.wallet_track_app.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Ripple {
    @SerializedName("ripple")
    @Expose
    var ripple: Bitcoin? = null
}