package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import java.lang.StringBuilder


class MainActivity : ComponentActivity() {
    private lateinit var resultText: TextView
    private lateinit var ac_Btn: Button
    private lateinit var upDownNum: Button
    private lateinit var procent: Button
    private lateinit var division: Button
    private lateinit var seven_Btn: Button
    private lateinit var eight_Btn: Button
    private lateinit var nine_Btn: Button
    private lateinit var four_Btn: Button
    private lateinit var five_Btn: Button
    private lateinit var six_Btn: Button
    private lateinit var one_Btn: Button
    private lateinit var two_Btn: Button
    private lateinit var three_Btn: Button
    private lateinit var zero_Btn: Button
    private lateinit var dot_Btn: Button
    private lateinit var equals_Btn: Button
    private lateinit var plus_Btn: Button
    private lateinit var minus_Btn: Button
    private lateinit var multiplication_Btn: Button

    var firstNum: Double = 0.0
    var secondNum: Double = 0.0
    var reserveNum: StringBuilder = StringBuilder()
    var signPressed: Boolean = false
    var sign: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultText = findViewById(R.id.result_text)
        ac_Btn = findViewById(R.id.ac_Btn)
        upDownNum = findViewById(R.id.upDownNum)
        procent = findViewById(R.id.procent)
        division = findViewById(R.id.division)
        seven_Btn = findViewById(R.id.seven_btn)
        eight_Btn = findViewById(R.id.eight_btn)
        nine_Btn = findViewById(R.id.nine_btn)
        four_Btn = findViewById(R.id.four_btn)
        five_Btn = findViewById(R.id.five_btn)
        six_Btn = findViewById(R.id.six_btn)
        one_Btn = findViewById(R.id.one_btn)
        two_Btn = findViewById(R.id.two_btn)
        three_Btn = findViewById(R.id.three_btn)
        zero_Btn = findViewById(R.id.zero_btn)
        dot_Btn = findViewById(R.id.dot_btn)
        equals_Btn = findViewById(R.id.equals_btn)
        plus_Btn = findViewById(R.id.plus)
        minus_Btn = findViewById(R.id.minus)
        multiplication_Btn = findViewById(R.id.multiplication)

        funcListen()
        numbersListen()
    }

    private fun funcListen() {
        upDownNum.setOnClickListener {
            reserveNum.append("-")
            resultText.text = reserveNum
        }
        ac_Btn.setOnClickListener {
            if (!resultText.text.equals("0")) {
                reserveNum.delete(0, reserveNum.length + 10)
                resultText.text = "0"
                firstNum = 0.0
                secondNum = 0.0
                signPressed = false
                sign = ""
            }
        }

        division.setOnClickListener {
            if (!signPressed) {
                firstNum = reserveNum.toString().toDouble()
                sign = "÷"
                resultText.text = sign
                signPressed = true
                reserveNum.delete(0, reserveNum.length + 10)
            }
        }

        multiplication_Btn.setOnClickListener {
            if (!signPressed) {
                firstNum = reserveNum.toString().toDouble()
                sign = "x"
                resultText.text = sign
                signPressed = true
                reserveNum.delete(0, reserveNum.length + 10)
            }
        }

        minus_Btn.setOnClickListener {
            if (!signPressed) {
                firstNum = reserveNum.toString().toDouble()
                sign = "-"
                resultText.text = sign
                signPressed = true
                reserveNum.delete(0, reserveNum.length + 10)
            }
        }
        plus_Btn.setOnClickListener {
            if (!signPressed) {
                firstNum = reserveNum.toString().toDouble()
                sign = "+"
                resultText.text = sign
                signPressed = true
                reserveNum.delete(0, reserveNum.length + 10)
            }
        }
        equals_Btn.setOnClickListener {
            secondNum = reserveNum.toString().toDouble()
            if (!firstNum.equals("") || !secondNum.equals("")) {
                when (sign) {
                    "÷" -> doDivision(firstNum, secondNum)
                    "x" -> doMultiplication(firstNum, secondNum)
                    "+" -> doSum(firstNum, secondNum)
                    "-" -> doMinus(firstNum, secondNum)
                }
            }
        }
    }

    private fun doMinus(firstNum: Double, secondNum: Double) {
        resultText.text = (firstNum - secondNum).toInt().toString()
    }

    private fun doSum(firstNum: Double, secondNum: Double) {
        resultText.text = (firstNum + secondNum).toInt().toString()
    }

    private fun doMultiplication(firstNum: Double, secondNum: Double) {
        resultText.text = (firstNum * secondNum).toInt().toString()
    }

    private fun doDivision(firstNum: Double, secondNum: Double) {
        resultText.text = (firstNum / secondNum).toInt().toString()
    }

    private fun numbersListen() {
        one_Btn.setOnClickListener {
            reserveNum.append("1")
            resultText.text = reserveNum
        }
        two_Btn.setOnClickListener {
            reserveNum.append("2")
            resultText.text = reserveNum
        }
        three_Btn.setOnClickListener {
            reserveNum.append("3")
            resultText.text = reserveNum
        }
        four_Btn.setOnClickListener {
            reserveNum.append("4")
            resultText.text = reserveNum
        }
        five_Btn.setOnClickListener {
            reserveNum.append("5")
            resultText.text = reserveNum
        }
        six_Btn.setOnClickListener {
            reserveNum.append("6")
            resultText.text = reserveNum
        }
        seven_Btn.setOnClickListener {
            reserveNum.append("7")
            resultText.text = reserveNum
        }
        eight_Btn.setOnClickListener {
            reserveNum.append("8")
            resultText.text = reserveNum
        }
        nine_Btn.setOnClickListener {
            reserveNum.append("9")
            resultText.text = reserveNum
        }
        zero_Btn.setOnClickListener {
            if (!resultText.text.equals("0")) {
                reserveNum.append("0")
                resultText.text = reserveNum
            }
        }
    }
}