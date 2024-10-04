package com.example.bottomnavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import java.text.DecimalFormat

class CalculatorFragment : Fragment() {

    private lateinit var etNumber1: EditText
    private lateinit var etNumber2: EditText
    private lateinit var tvResult: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_calculator, container, false)

        // Initialize views
        etNumber1 = view.findViewById(R.id.etNumber1)
        etNumber2 = view.findViewById(R.id.etNumber2)
        tvResult = view.findViewById(R.id.tvResult)

        val btnAdd: Button = view.findViewById(R.id.btnAdd)
        val btnSubtract: Button = view.findViewById(R.id.btnSubtract)
        val btnMultiply: Button = view.findViewById(R.id.btnMultiply)
        val btnDivide: Button = view.findViewById(R.id.btnDivide)

        // Set click listeners for buttons
        btnAdd.setOnClickListener { calculate('+') }
        btnSubtract.setOnClickListener { calculate('-') }
        btnMultiply.setOnClickListener { calculate('*') }
        btnDivide.setOnClickListener { calculate('/') }

        return view
    }

    private fun calculate(operation: Char) {
        val number1 = etNumber1.text.toString().toDoubleOrNull()
        val number2 = etNumber2.text.toString().toDoubleOrNull()

        if (number1 == null || number2 == null) {
            tvResult.text = "Please enter valid numbers"
            return
        }

        val result = when (operation) {
            '+' -> number1 + number2
            '-' -> number1 - number2
            '*' -> number1 * number2
            '/' -> if (number2 != 0.0) number1 / number2 else null
            else -> null
        }

        val df = DecimalFormat("#.##")
        tvResult.text = if (result != null) "Result: ${df.format(result)}" else "Error"
    }
}
