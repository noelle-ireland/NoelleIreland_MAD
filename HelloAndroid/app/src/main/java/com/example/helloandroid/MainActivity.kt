package com.example.helloandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var editName: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sayBoo(view: View) {
        val booText = findViewById<TextView>(R.id.textMessage)
        editName = findViewById(R.id.editTextName)
        val name = editName.text
        booText.setText("Happy Turkey Day (almost) " + name + "!")
        val imageTurkey = findViewById<ImageView>(R.id.imageView)
        imageTurkey.setImageResource(R.drawable.turkeyday)
    }
}