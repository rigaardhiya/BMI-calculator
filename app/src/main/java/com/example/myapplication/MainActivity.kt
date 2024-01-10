package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val calculateBtn = findViewById<Button>(R.id.calculateBtn)
        val resetBtn = findViewById<Button>(R.id.resetBtn)

        calculateBtn.setOnClickListener { calculate() }
        resetBtn.setOnClickListener { resetInputs() }
    }

    private fun resetInputs() {
        val editTextHeight = findViewById<EditText>(R.id.editTextHeight)
        val editTextWeight = findViewById<EditText>(R.id.editTextWeight)
        val editTextNama = findViewById<EditText>(R.id.editTextNama)
        val editTextAl = findViewById<EditText>(R.id.editTextAl)

        editTextAl.setText("")
        editTextNama.setText("")
        editTextWeight.setText("")
        editTextHeight.setText("")
    }

    private fun calculate() {
        var gender = "Laki - laki"
        val editTextHeight = findViewById<EditText>(R.id.editTextHeight)
        val editTextWeight = findViewById<EditText>(R.id.editTextWeight)
        val editTextNama = findViewById<EditText>(R.id.editTextNama)
        val editTextAl = findViewById<EditText>(R.id.editTextAl)
        val genders = findViewById<RadioGroup>(R.id.radioGroupGender)
        val resultText = findViewById<TextView>(R.id.result)

        val height = editTextHeight.text.toString().toDouble()
        val weight = editTextWeight.text.toString().toDouble()
        val nama = editTextNama.text.toString()
        val al = editTextAl.text.toString()

        val selectedGender = genders.checkedRadioButtonId

        gender = when (selectedGender) {
            R.id.radioButtonMale -> "Laki-laki"
            R.id.radioButtonFemale -> "Perempuan"
            else -> "Laki-laki"
        }

        val bmi = when (gender) {
            "Laki-laki" -> weight / ((height / 100) * (height / 100))
            "Perempuan" -> weight / ((height / 100) * (height / 100)) * 0.9
            else -> 0.0
        }

        val result = "Hasil: $nama kamu orang $al yang " + when {
            bmi < 18.5 -> "Kekurangan gizi"
            bmi >= 18.5 && bmi < 24.9 -> "Normal"
            bmi >= 25 && bmi < 29.9 -> "Kelebihan gizi"
            else -> "Obesitas"
        }

        resultText.text = result
    }
}