package com.dtechatoms.fiatfix.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dtechatoms.fiatfix.R
import com.dtechatoms.fiatfix.adapters.HomeFragmentAdapter
import com.dtechatoms.fiatfix.databinding.FragmentHomeBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<LinearLayout>
    private lateinit var binding: FragmentHomeBinding

    private val cryptie = listOf(
        Crypto(R.drawable.ic_green_arrow_up, R.drawable.ic_btc, "2.3584456", "Active"),
        Crypto(R.drawable.ic_red_arrow_down, R.drawable.ic_ltc, "0.22500", "Passive"),
        Crypto(R.drawable.ic_green_arrow_up, R.drawable.ic_eth, "2.3584456", "Active")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)

        val drawerLayout = activity?.drawer_layout
        binding.drawerButton.setOnClickListener {
            drawerLayout?.openDrawer(GravityCompat.START)
        }

        binding.learnToInvest.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmetToLearnFragment())
        }

        binding.recyclerViewLiveInvestment.adapter =
            HomeFragmentAdapter(cryptie, HomeFragmentAdapter.CryptoClickListener {
                findNavController().navigate(HomeFragmentDirections.actionHomeFragmetToInvestmentDetailsFragment())
            })

        binding.imgAddInvestment.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToChooseInvestmentFragment())
        }

        binding.recyclerViewGuranteed.adapter =
            HomeFragmentAdapter(cryptie, HomeFragmentAdapter.CryptoClickListener {

            })

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)
    }
}

data class Crypto(
    val cryptoArrow: Int,
    val cryptoImage: Int,
    val amount: String,
    val action: String
)
