package com.example.lab8

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.content_ice_cream.*

data class IceCreamActivity(var name: String = "") : AppCompatActivity() {

    private var iceCreamShopName : String? = null
    private var iceCreamShopUrl : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ice_cream)
        setSupportActionBar(findViewById(R.id.toolbar))

        iceCreamShopName = intent.getStringExtra("iceCreamShopName")
        iceCreamShopUrl = intent.getStringExtra("iceCreamShopUrl")

        iceCreamShopName?.let { Log.i("shop recieved", it) };
        iceCreamShopUrl?.let { Log.i("url recieved", it) };

        iceCreamShopName?.let { IceCreamFlavortextView.text = "The flavor of the day is $iceCreamShopName"}

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { loadWebsite()
        }
    }

    fun loadWebsite(){
        //create intent
        var intent = Intent()
        intent.action = Intent.ACTION_VIEW
        intent.data = iceCreamShopUrl?.let { Uri.parse(iceCreamShopUrl) }
        startActivity(intent)
        //snackbar

        }

    override fun onBackPressed() {
        val data=Intent()
        data.putExtra("feedback", feedbackEditText.text.toString())
        setResult(Activity.RESULT_OK, data)
        super.onBackPressed()
        finish()
    }
}