package com.example.colorcounter

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
retriveCount()

        buttonRed.setOnClickListener {
            countText.setBackgroundColor(Color.RED)
            onTap()
        }
        buttonBlue.setOnClickListener{
            onTap()
            countText.setBackgroundColor(Color.BLUE)
        }
        buttonGreen.setOnClickListener{
            onTap()
            countText.setBackgroundColor(Color.GREEN)
        }

        buttonYellow.setOnClickListener{
            onTap()
            countText.setBackgroundColor(Color.YELLOW)
        }
        buttonReset.setOnClickListener{
            onTap()

        }
    }

    var count = 0

fun onTap() {

if( buttonReset.isPressed){
       count = 0
    val textView = findViewById(R.id.countText) as TextView
    textView.text = count.toString()
    countText.setBackgroundColor(Color.TRANSPARENT)

} else{

    count++
    val textView = findViewById(R.id.countText) as TextView
    textView.text = count.toString()

    val mypref = getSharedPreferences("mypref", Context.MODE_PRIVATE)
    val editor =   mypref.edit()
    editor.putString("count", textView.text.toString())
    editor.apply()
}


}

    private  fun retriveCount(){
        val mypref = getSharedPreferences("mypref", Context.MODE_PRIVATE)
        val countPref =  mypref.getString("count","" )
        countText.text = countPref

    }

}


