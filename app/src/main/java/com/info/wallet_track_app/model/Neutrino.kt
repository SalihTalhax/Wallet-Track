package com.info.wallet_track_app.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Neutrino {
    @SerializedName("neutrino")
    @Expose
    var neutrino: Bitcoin? = null

}