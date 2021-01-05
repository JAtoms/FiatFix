package com.dtechatoms.fiatfix.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dtechatoms.fiatfix.R
import com.dtechatoms.fiatfix.ui.Learn

/**
 * Created by Joshua Nwokoye on 12/10/2020.
 */

class LearnFragmentAdapter(val list: List<Learn>, val clickListener: CryptoClickListener) : RecyclerView.Adapter<LearnViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LearnViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return LearnViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: LearnViewHolder, position: Int) {
        val learn: Learn = list[position]
        holder.itemView.setOnClickListener {
            clickListener.onClick(learn)
        }
        holder.bind(learn)
    }

    class CryptoClickListener(val clickListener: (learn: Learn) -> Unit) {
        fun onClick(learn: Learn) = clickListener(learn)
    }

}

class LearnViewHolder(inflater: LayoutInflater, parent: ViewGroup) : RecyclerView.ViewHolder(
    inflater.inflate(R.layout.item_learn, parent, false))
{
    private var cryptImage: ImageView? = null
    private var cryptHeading: TextView? = null
    private var cryptContent: TextView? = null

    init {
        cryptImage = itemView.findViewById(R.id.img_crypto)
        cryptHeading = itemView.findViewById(R.id.txt_heading)
        cryptContent = itemView.findViewById(R.id.txt_cry_detail)
    }

    fun bind(learn: Learn){
        cryptImage?.setImageResource(learn.cryptoImage)
        cryptHeading?.text = learn.header
        cryptContent?.text = learn.content
    }
}