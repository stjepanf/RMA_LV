package com.example.inspiringperson

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.inspiringperson.Person.pers
import com.example.inspiringperson.Person
import kotlinx.android.synthetic.main.activity_input_form.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row.*
import kotlinx.android.synthetic.main.row.view.*
import kotlinx.android.synthetic.main.row.view.imageCard

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myAdapter = MyAdapter(pers, this)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter=myAdapter

    setUpUi()


    }

    private fun setUpUi(){
        input.setOnClickListener { navigateToDetails() }
    }

private fun navigateToDetails(){

        val detailsIntent: Intent = Intent(this, Inputform::class.java)
        startActivity(detailsIntent)}

        

}

