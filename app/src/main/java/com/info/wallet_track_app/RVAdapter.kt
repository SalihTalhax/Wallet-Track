package com.info.wallet_track_app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class RVAdapter(private val mContext:Context,private val coinlist:List<coins>)
    :RecyclerView.Adapter<RVAdapter.CardViewNesneTutucu>() {

    inner class CardViewNesneTutucu(view:View):RecyclerView.ViewHolder(view){

    var satirCardView:CardView
    var satiryazi:TextView
    var satiryazi2:TextView
    var resmim:ImageView

    init {
        satirCardView=view.findViewById(R.id.satirCardView)
        satiryazi= view.findViewById(R.id.satiryazi)
        satiryazi2=view.findViewById(R.id.satiryazi2)
        resmim=view.findViewById(R.id.resmim)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewNesneTutucu {

        val tasarim=LayoutInflater.from(mContext).inflate(R.layout.card_tasarim,parent,false)
        return CardViewNesneTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardViewNesneTutucu, position: Int) {
        val koin = coinlist[position]
        val tel = coinlist[position]
        val pon =coinlist[position]

        holder.satiryazi2.__()=pon.coinno

        holder.satiryazi.text= koin.Coinadı

        holder.satirCardView.setOnClickListener{

            Toast.makeText( mContext, "Seçtiğiniz Coin:${koin.Coinadı}", Toast.LENGTH_SHORT).show()
        }

    }

    override fun getItemCount(): Int {
        return coinlist.size
    }

}