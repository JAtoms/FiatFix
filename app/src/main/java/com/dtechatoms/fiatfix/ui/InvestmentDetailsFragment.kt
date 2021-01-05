package com.dtechatoms.fiatfix.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dtechatoms.fiatfix.R
import com.dtechatoms.fiatfix.databinding.FragmentInvestmentDetailsBinding


class InvestmentDetailsFragment : Fragment() {

    private lateinit var binding: FragmentInvestmentDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInvestmentDetailsBinding.inflate(inflater)
        inflater.context.setTheme(R.style.ThemeFragment)

        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
        return binding.root
    }
}