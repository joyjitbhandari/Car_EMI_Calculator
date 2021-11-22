package com.joyjit.caremicalculator

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.provider.MediaStore
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    lateinit var etPrincipalAmount: EditText
    lateinit var etDownPayment: EditText
    lateinit var etInterestRate: EditText
    lateinit var etLoanTerm: EditText
    lateinit var tableLayout: TableLayout

    lateinit var btButton: Button
    lateinit var txResult: TextView
    lateinit var txTotalResult: TextView

    lateinit var btClear: Button
    lateinit var btExit: Button

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        tableLayout = findViewById(R.id.layout1)
        etPrincipalAmount = findViewById(R.id.etPrincipleAmount)
        etDownPayment = findViewById(R.id.etDownPayment)
        etInterestRate = findViewById(R.id.etInterestRate)
        etLoanTerm = findViewById(R.id.etLoanTerm)

        btButton = findViewById(R.id.button)
        txResult = findViewById(R.id.txResult)
        txTotalResult = findViewById(R.id.txTotalResult)

        btClear = findViewById(R.id.btClear)
        btExit = findViewById(R.id.btExit)


            btButton.setOnClickListener{
                val principalAmount = etPrincipalAmount.text.toString()
                val downPayment = etDownPayment.text.toString()
                val interestRate = etInterestRate.text.toString()
                val loanTerm = etLoanTerm.text.toString()
                if (principalAmount.isNotBlank()&&downPayment.isNotBlank()){
                    if (interestRate.isNotBlank() && loanTerm.isNotBlank()){
                        val p:Double = principalAmount.toDouble()
                        val d:Double = downPayment.toDouble()
                        val r:Double = interestRate.toDouble()
                        val t:Double = loanTerm.toDouble()


                        val P:Double = p-d
                        val R:Double = r/1200
                        val result  = (P*R*((1+R).pow(t)/(((1+R).pow(t))-1)))

                        val totalResult = (result*t)

                        txResult.text = "Monthly EMI:- $result"
                        txTotalResult.text = "Return Amount With Interest:- $totalResult"

                    }else{
                        Toast.makeText(this, "Enter all credentials", Toast.LENGTH_SHORT).show()
                    }
                }else{
                    Toast.makeText(this, "Enter all credentials", Toast.LENGTH_SHORT).show()
                }
            }


        btClear.setOnClickListener {
            val principalAmount = etPrincipalAmount.text.toString()
            val downPayment = etDownPayment.text.toString()
            val interestRate = etInterestRate.text.toString()
            val loanTerm = etLoanTerm.text.toString()
            if (principalAmount.isNotBlank()&&downPayment.isNotBlank()) {
                if (interestRate.isNotBlank() && loanTerm.isNotBlank()) {

                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()

                }else{ Toast.makeText(this, "Can't Do", Toast.LENGTH_SHORT).show()}
            }else{ Toast.makeText(this, "Can't Do", Toast.LENGTH_SHORT).show()}
        }
        btExit.setOnClickListener { onBackPressed() }

    }
}

