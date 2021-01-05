package com.dtechatoms.fiatfix.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dtechatoms.fiatfix.R
import com.dtechatoms.fiatfix.ui.ChooseInvest

/**
 * Created by Joshua Nwokoye on 12/10/2020.
 */

class ChoseInvestmentFragmentAdapter(
    val chooseInvest: List<ChooseInvest>,
    val clickListener: CryptoClickListener
) : RecyclerView.Adapter<ChooseInvestmentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChooseInvestmentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ChooseInvestmentViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int = chooseInvest.size

    override fun onBindViewHolder(holder: ChooseInvestmentViewHolder, position: Int) {
        val chooseInvest: ChooseInvest = chooseInvest[position]
        holder.itemView.setOnClickListener {
            clickListener.onClick(chooseInvest)
        }
        holder.bind(chooseInvest)
    }

    class CryptoClickListener(val clickListener: (chooseInvest: ChooseInvest) -> Unit) {
        fun onClick(chooseInvest: ChooseInvest) = clickListener(chooseInvest)
    }

}

class ChooseInvestmentViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(
        inflater.inflate(R.layout.item_choose_investment, parent, false)
    ) {
    private var cryptImage: ImageView? = null
    private var cryptIcon: ImageView? = null
    private var cryptValue: TextView? = null

    init {
        cryptImage = itemView.findViewById(R.id.img_crypt)
        cryptIcon = itemView.findViewById(R.id.crypto_icon)
        cryptValue = itemView.findViewById(R.id.txt_value_pips)
    }

    fun bind(chooseInvest: ChooseInvest) {
        cryptImage?.setImageResource(chooseInvest.cryptoImage)
        cryptIcon?.setImageResource(chooseInvest.cryptIcon)
        cryptValue?.text = chooseInvest.pipsValue
    }
}