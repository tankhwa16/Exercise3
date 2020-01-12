package com.example.exercise3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener {
            calculate()
        }

        buttonReset.setOnClickListener {
            reset()
        }
    }

    fun calculate() {
        val ageId = spinnerAge.selectedItemPosition.toString().toInt()
        val gender = findViewById<RadioButton>(radioGroupGender.checkedRadioButtonId).text
        var premium = 0

        when (ageId) {
            0 -> premium += 60
            1 -> premium += 70
            2 -> premium += 90
            3 -> premium += 120
            4 -> premium += 150
            5 -> premium += 150
        }

        if(gender == "Male"){
            when (ageId) {
                0 -> premium += 0
                1 -> premium += 50
                2 -> premium += 100
                3 -> premium += 150
                4 -> premium += 200
                5 -> premium += 200
            }
        }

        if(checkBoxSmoker.isChecked){
            when (ageId) {
                0 -> premium += 0
                1 -> premium += 100
                2 -> premium += 150
                3 -> premium += 200
                4 -> premium += 250
                5 -> premium += 300
            }
        }

        textViewPremium.setText("Insurance Premium : " +premium)



    }

    fun reset(){
        spinnerAge.setSelection(0);
        radioGroupGender.clearCheck();
        checkBoxSmoker.setChecked(false)

            textViewPremium.setText("Insurance Premium : ")
    }
}
