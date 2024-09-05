package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private lateinit var etNumber1: EditText
    private lateinit var etNumber2: EditText
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etNumber1 = findViewById(R.id.etNumber1)
        etNumber2 = findViewById(R.id.etNumber2)
        tvResult = findViewById(R.id.tvResult)

        val btnAdd: Button = findViewById(R.id.btnAdd)
        val btnSubtract: Button = findViewById(R.id.btnSubtract)
        val btnMultiply: Button = findViewById(R.id.btnMultiply)
        val btnDivide: Button = findViewById(R.id.btnDivide)

        btnAdd.setOnClickListener { calculate('+') }
        btnSubtract.setOnClickListener { calculate('-') }
        btnMultiply.setOnClickListener { calculate('*') }
        btnDivide.setOnClickListener { calculate('/') }
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