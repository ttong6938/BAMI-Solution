package com.example.patient_app.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import com.example.patient_app.R
import kotlinx.android.synthetic.main.activity_hamilton3year.*
import kotlinx.android.synthetic.main.activity_hamilton3year.*

class Hamilton_3yearActivity : AppCompatActivity() {
    private var toast: Toast? = null
    private fun makeToast(message: String){
        try{
            toast?.cancel()
            toast = Toast.makeText(applicationContext,message, Toast.LENGTH_SHORT)
            toast?.show()
        }catch (e: java.lang.Exception){
            e.printStackTrace()
        }}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hamilton3year)

        var hamilton_score1=0
        var hamilton_score2=0
        var hamilton_score3=0
        var hamilton_score4=0
        var hamilton_score5=0

        hamiltonSave_btn.setOnClickListener({

            for (i in 1..21) {
                val one = resources.getIdentifier("Hamilton$i"+"_1","id", packageName)
                val two = resources.getIdentifier("Hamilton$i"+"_2","id", packageName)
                val three = resources.getIdentifier("Hamilton$i"+"_3","id", packageName)
                val four = resources.getIdentifier("Hamilton$i"+"_4","id", packageName)
                val five = resources.getIdentifier("Hamilton$i"+"_5","id", packageName)

                val radioButtonOne = findViewById<RadioButton>(one)
                val radioButtonTwo = findViewById<RadioButton>(two)
                val radioButtonThree = findViewById<RadioButton>(three)
                val radioButtonFour = findViewById<RadioButton>(four)
                val radioButtonFive = findViewById<RadioButton>(five)

                if (radioButtonOne.isChecked){
                    hamilton_score1++
                    Hamilton.hamilton[i-1] = "1"
                }
                else if (radioButtonTwo.isChecked){
                    hamilton_score2 = hamilton_score2+2
                    Hamilton.hamilton[i-1] = "2"
                }
                else if (radioButtonThree.isChecked){
                    hamilton_score3 = hamilton_score3+3
                    Hamilton.hamilton[i-1] = "3"
                }
                else if (radioButtonFour.isChecked){
                    hamilton_score4 = hamilton_score4+4
                    Hamilton.hamilton[i-1] = "4"
                }
                else if (radioButtonFive.isChecked){
                    hamilton_score5 = hamilton_score5+5
                    Hamilton.hamilton[i-1] = "5"
                }
                else{
                    makeToast("$i 번에 응답해 주세요.")
                }
            }

            Toast.makeText(this,"저장 완료",Toast.LENGTH_SHORT).show()



        })

        hamiltonNext_btn.setOnClickListener({
            var intent1 = Intent(this, SSI_3yearActivity::class.java)
            startActivity((intent1))
        })



    }
}