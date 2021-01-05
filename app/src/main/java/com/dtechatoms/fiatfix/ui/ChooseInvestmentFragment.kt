package com.dtechatoms.fiatfix.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.dtechatoms.fiatfix.R
import com.dtechatoms.fiatfix.adapters.ChoseInvestmentFragmentAdapter
import com.dtechatoms.fiatfix.databinding.FragmentChooseInvestmentBinding


class ChooseInvestmentFragment : Fragment() {

    private lateinit var binding: FragmentChooseInvestmentBinding
    private val chooseInvest = listOf(
        ChooseInvest(R.drawable.ic_img_btc_chart, R.drawable.ic_btc_yellow, "+0.022pips"),
        ChooseInvest(R.drawable.ic_img_btc_chart, R.drawable.ic_eth_blue, "+0.022pips"),
        ChooseInvest(R.drawable.ic_img_btc_chart, R.drawable.ic_bnb, "+0.022pips"),
        ChooseInvest(R.drawable.ic_img_btc_chart, R.drawable.ic_ltc_black, "+0.022pips"),
        ChooseInvest(R.drawable.ic_img_btc_chart, R.drawable.ic_btc_yellow, "+0.022pips"),
        ChooseInvest(R.drawable.ic_img_btc_chart, R.drawable.ic_eth_blue, "+0.022pips"),
        ChooseInvest(R.drawable.ic_img_btc_chart, R.drawable.ic_bnb, "+0.022pips"),
        ChooseInvest(R.drawable.ic_img_btc_chart, R.drawable.ic_ltc_black, "+0.022pips")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChooseInvestmentBinding.inflate(inflater)

        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.recyclerChooseInvest.adapter = ChoseInvestmentFragmentAdapter(chooseInvest, ChoseInvestmentFragmentAdapter.CryptoClickListener{
            findNavController().navigate(ChooseInvestmentFragmentDirections.actionChooseInvestmentFragmentToInvestmentFragment())
        })

        return binding.root
    }
}

data class ChooseInvest(
    val cryptoImage: Int,
    val cryptIcon: Int,
    val pipsValue: String
)