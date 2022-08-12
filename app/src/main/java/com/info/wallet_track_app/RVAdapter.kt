package com.info.wallet_track_app

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RVAdapter(private val mContext: Context) :
    RecyclerView.Adapter<RVAdapter.CardViewDesignObjectsHolder>() {

    private val cryptoList: MutableList<Coin> = ArrayList<Coin>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewDesignObjectsHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_tasarim, parent, false)
        return CardViewDesignObjectsHolder(itemView)
    }

    override fun onBindViewHolder(holder: CardViewDesignObjectsHolder, position: Int) {
        holder.coinName.text = cryptoList[position].coinName
        holder.coinPrice.text = cryptoList[position].coinPrice

        holder.itemContainer.setOnClickListener {
            val intent = Intent(mContext, DetailActivity::class.java)
            intent.putExtra("coinId", cryptoList[position].coinName)
            mContext.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return cryptoList.size
    }

    fun setData(cryptoList: List<Coin>?) {
        this.cryptoList.clear()
        this.cryptoList.addAll(cryptoList!!)
        // Ekranın yeni verilerle yenilenmesini sağlayan kod
        notifyDataSetChanged()
    }

    inner class CardViewDesignObjectsHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        var itemContainer: RelativeLayout
        var coinName: TextView
        var coinPrice: TextView

        init {
            coinName = view.findViewById(R.id.satiryazi)
            coinPrice = view.findViewById(R.id.satiryazi2)
            itemContainer = view.findViewById(R.id.itemContainer)
        }
    }
}