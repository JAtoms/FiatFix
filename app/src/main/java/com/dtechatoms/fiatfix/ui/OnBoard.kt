package com.dtechatoms.fiatfix.ui

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.dtechatoms.fiatfix.R
import com.dtechatoms.fiatfix.databinding.ActivityOnBoardBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior

class OnBoard : AppCompatActivity() {

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<LinearLayout>
    private lateinit var binding: ActivityOnBoardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_on_board)


//        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)
//        binding.loginBtn1.setOnClickListener {
//            if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED)
//                bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
//            else{
//                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
//                bottomSheetBehavior.getScrimColor(binding.cordinatorLayout, binding.bottomSheet)
//            }
//
//        }

//        bottomSheetBehavior = BottomSheetBehavior.from(login_bottom_sheet)
//        bottomSheetBehavior = BottomSheetBehavior.from(registration_bottom_sheet)

        binding.loginBtn1.setOnClickListener {
            LoginBottomSheetFragment().apply {
                show(supportFragmentManager, tag)
            }
        }

        binding.signUp1.setOnClickListener {
            RegisterBottomSheetFragment().apply {
                show(supportFragmentManager, tag)
            }
        }

    }
}