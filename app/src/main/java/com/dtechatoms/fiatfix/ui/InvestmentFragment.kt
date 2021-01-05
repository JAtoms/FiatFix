package com.dtechatoms.fiatfix.ui

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dtechatoms.fiatfix.R
import com.dtechatoms.fiatfix.databinding.FragmentInvestmentBinding
import java.text.SimpleDateFormat
import java.util.*
var hour = 0

class InvestmentFragment : Fragment(){

    private lateinit var binding: FragmentInvestmentBinding
    var cryptoCoins = arrayOf("Btc", "Eth", "Doge", "Ltc", "Trx")
    var dateFormat = SimpleDateFormat("dd, MMM, YYYY", Locale.US)

    var day = 0
    var month = 0
    var year = 0
    var min = 0

    var investmentAmount = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInvestmentBinding.inflate(inflater)

        val arrayAdapter = ArrayAdapter(requireActivity(), android.R.layout.simple_spinner_dropdown_item, cryptoCoins)
        binding.spinCryptoCurrency.adapter = arrayAdapter

        binding.btnBack.setOnClickListener {
            if (investmentAmount){
                investmentAmount = false
                binding.paymentOptions.visibility = View.GONE
                binding.layoutInvestmentAmount.visibility = View.VISIBLE
            } else{
                findNavController().navigateUp()
            }

        }

        binding.spinCryptoCurrency.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(context, "Nothing", Toast.LENGTH_SHORT).show()
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Toast.makeText(context, "Something", Toast.LENGTH_SHORT).show()
            }

        }

        binding.dateStart.setOnClickListener {
            getTimeCalendar()
            datePicker(binding.txtStartDate)
        }

        binding.dateEnd.setOnClickListener {
            getTimeCalendar()
            datePicker(binding.txtEndDate)
        }

        binding.btnContinue.setOnClickListener {
            binding.paymentOptions.visibility = View.VISIBLE
            binding.layoutInvestmentAmount.visibility = View.GONE
            investmentAmount = true
        }

        binding.btnCancel.setOnClickListener {
            findNavController().navigateUp()
        }

//        binding.btnContinue.setOnClickListener {
//            CardDetailsBottomSheetFragment().apply {
//                show(context, tag)
//            }
//        }

        return binding.root
    }

    private fun getTimeCalendar() {
        val calendar = Calendar.getInstance()
        day = calendar.get(Calendar.DAY_OF_MONTH)
        month = calendar.get(Calendar.MONTH)
        year  = calendar.get(Calendar.YEAR)
        hour = calendar.get(Calendar.HOUR)
        min = calendar.get(Calendar.MINUTE)
    }

    private fun datePicker(textView: TextView){
        DatePickerDialog(this.requireActivity(), DatePickerDialog.OnDateSetListener { view, year, month, day ->
            textView.text = "$day/$month/$year"
            textView.setTextColor(Color.DKGRAY)
        }, year, month, day).show()
    }
}