package com.dtechatoms.fiatfix.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dtechatoms.fiatfix.R
import com.dtechatoms.fiatfix.ui.Crypto

/**
 * Created by Joshua Nwokoye on 12/10/2020.
 */

class HomeFragmentAdapter(val list: List<Crypto>, val clickListener: CryptoClickListener) : RecyclerView.Adapter<CryptoViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CryptoViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
        val crypto: Crypto = list[position]
        holder.itemView.setOnClickListener {
            clickListener.onClick(crypto)
        }
        holder.bind(crypto)
    }

    class CryptoClickListener(val clickListener: (crypto: Crypto) -> Unit) {
        fun onClick(crypto: Crypto) = clickListener(crypto)
    }

}

class CryptoViewHolder(inflater: LayoutInflater, parent: ViewGroup) : RecyclerView.ViewHolder(
    inflater.inflate(R.layout.item_home_investment, parent, false))
{
    private var cryptImage: ImageView? = null
    private var cryptArrow: ImageView? = null
    private var crypCtive: TextView? = null
    private var cryptValue: TextView? = null

    init {
        cryptImage = itemView.findViewById(R.id.crypto_image)
        cryptArrow = itemView.findViewById(R.id.crypt_arrow)
        crypCtive = itemView.findViewById(R.id.txt_view_active)
        cryptValue = itemView.findViewById(R.id.txt_crypto_price)
    }

    fun bind(crypto: Crypto){
        val action = crypto.action
        cryptImage?.setImageResource(crypto.cryptoImage)
        cryptArrow?.setImageResource(crypto.cryptoArrow)

        if (action == "Passive"){
            crypCtive?.setTextColor(Color.parseColor("#E70404"))
        }
        crypCtive?.text = crypto.action
        cryptValue?.text = crypto.amount
    }
}