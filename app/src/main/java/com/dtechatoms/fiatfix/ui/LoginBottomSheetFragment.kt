package com.dtechatoms.fiatfix.ui

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.dtechatoms.fiatfix.MainActivity
import com.dtechatoms.fiatfix.databinding.LoginBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/**
 * Created by Joshua Nwokoye on 12/9/2020.
 */
class LoginBottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding: LoginBottomSheetBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LoginBottomSheetBinding.inflate(inflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (view?.parent as View).setBackgroundColor(Color.TRANSPARENT)

        binding.loginBtn2.setOnClickListener {
            startActivity(Intent(context, MainActivity::class.java))

        }
    }
}