package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttoncalculate.setOnClickListener{
            calculate()
        }
        buttonreset.setOnClickListener {
            reset()
        }
    }

    private fun reset() {
        editTextheight.text.clear()
        editTextweight.text.clear()
        imageView.setImageResource(R.drawable.normal)
        textView.setText(getString(R.string.BMI))
    }

    private fun calculate() {
        if(editTextheight.text.toString().isEmpty()){
            editTextheight.setError(getString(R.string.inputError))
            return
        }
        if(editTextweight.text.toString().isEmpty()){
            editTextweight.setError(getString(R.string.inputError))
            return
        }
        val height=editTextheight.text.toString().toFloat()
        val weight=editTextweight.text.toString().toFloat()
        val bmi=weight/(height/100).pow(2)

        if(bmi<18.5){
            textView.text=String.format("%s %.2f (%s",getString(R.string.BMI),bmi,getString((R.string.under)))
            imageView.setImageResource(R.drawable.under)
        }
        else if(bmi in 18.5..24.5){
            textView.text=String.format("%s %.2f (%s",getString(R.string.BMI),bmi,getString((R.string.normal)))
            imageView.setImageResource(R.drawable.normal)
        }
        else if(bmi >25){
            textView.text=String.format("%s %.2f (%s",getString(R.string.BMI),bmi,getString((R.string.over)))
            imageView.setImageResource(R.drawable.over)
        }

    }
}
