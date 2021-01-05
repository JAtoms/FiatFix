package com.dtechatoms.fiatfix.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dtechatoms.fiatfix.R
import com.dtechatoms.fiatfix.adapters.LearnFragmentAdapter
import com.dtechatoms.fiatfix.databinding.FragmentLearnBinding

class LearnFragment : Fragment() {

    private lateinit var binding: FragmentLearnBinding

    private val learn = listOf(
        Learn(
            R.drawable.img_btc_coin,
            "Understanding Crypto Currency",
            "A cryptocurrency is a digital or virtual currency that is secured by cryptography,"
        ),
        Learn(
            R.drawable.img_btc_learn,
            "Auto Fiat-Crypto Conversion",
            "A defining feature of cryptocurrencies is that they are"
        ),
        Learn(
            R.drawable.img_btc_dollar,
            "Know what Fiat is",
            "Many cryptocurrencies are decentralized networks based on blockchain"
        ),
        Learn(
            R.drawable.img_btc_coin,
            "Trading crypto",
            "A cryptocurrency is a digital or virtual currency that is secured by cryptography,"
        ),
        Learn(
            R.drawable.img_btc_learn,
            "The crypto trade",
            "A defining feature of cryptocurrencies is that they are"
        ),
        Learn(
            R.drawable.img_btc_dollar,
            "Know what crypto conversion is",
            "Many cryptocurrencies are decentralized networks based on blockchain"
        ),
        Learn(
            R.drawable.img_btc_coin,
            "The crypto public ledger",
            "A cryptocurrency is a digital or virtual currency that is secured by cryptography,"
        ),
        Learn(
            R.drawable.img_btc_learn,
            "Fiat to crypto conversion",
            "A defining feature of cryptocurrencies is that they are"
        ),
        Learn(
            R.drawable.img_btc_dollar,
            "The crypto rule",
            "Many cryptocurrencies are decentralized networks based on blockchain"
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLearnBinding.inflate(inflater)
        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.recyclerLearn.adapter =
            LearnFragmentAdapter(learn, LearnFragmentAdapter.CryptoClickListener {
               // Toast.makeText(context, "Click", Toast.LENGTH_SHORT).show()
            })

        return binding.root
    }

}

data class Learn(
    val cryptoImage: Int,
    val header: String,
    val content: String
)