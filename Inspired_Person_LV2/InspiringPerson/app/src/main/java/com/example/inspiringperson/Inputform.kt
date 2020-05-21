package com.example.inspiringperson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_input_form.*


class Inputform : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_form)

        val nameEn = findViewById<EditText>(R.id.inputname)
        val dobEn = findViewById<EditText>(R.id.inputyeahr)
        val descEn = findViewById<EditText>(R.id.inputdescription)

        btnSave.setOnClickListener {

             val ime = nameEn.text.toString()
            val godina = dobEn.text.toString()
            val opis = descEn.text.toString()
            val intent = Intent(this@Inputform , MainActivity::class.java)
            intent.putExtra( "Ime", ime)
            intent.putExtra("Godina", godina)
            intent.putExtra("Opis", opis)
            startActivity(intent)
        }
    }
}
