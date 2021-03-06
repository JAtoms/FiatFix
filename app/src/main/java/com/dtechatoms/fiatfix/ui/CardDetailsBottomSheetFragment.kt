package com.dtechatoms.fiatfix.ui

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.dtechatoms.fiatfix.MainActivity
import com.dtechatoms.fiatfix.databinding.CardDetailsBottomSheetBinding
import com.dtechatoms.fiatfix.databinding.LoginBottomSheetBinding
import com.dtechatoms.fiatfix.databinding.RegistrationBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/**
 * Created by Joshua Nwokoye on 12/9/2020.
 */
class CardDetailsBottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding: CardDetailsBottomSheetBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CardDetailsBottomSheetBinding.inflate(inflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (view?.parent as View).setBackgroundColor(Color.TRANSPARENT)

//        binding.btnCancel.setOnClickListener {
//            startActivity(Intent(context, MainActivity::class.java))
//        }
    }
}