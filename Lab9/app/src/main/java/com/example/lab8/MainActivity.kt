package com.example.lab8

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var myIceCreamShop = IceCreamShop();
    private var selectedLocationPosition= 0
    private val REQUEST_CODE = 1
    private var feedbackMessage:String? = null

    var message: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //event listener
        locationButton.setOnClickListener{
            selectedLocationPosition = spinner.selectedItemPosition
            myIceCreamShop.suggestIceCreamFlavor(selectedLocationPosition)
            Log.i("flavor suggested", myIceCreamShop.name);
            Log.i("url suggested", myIceCreamShop.url);

            //intent
            val intent = Intent(this, IceCreamActivity::class.java)
            intent.putExtra("iceCreamShopName", myIceCreamShop.name)
            intent.putExtra("iceCreamShopUrl", myIceCreamShop.url)

            startActivityForResult(intent, REQUEST_CODE)

        }
    }

    fun createSundae(view: View) {
        var iceCream: CharSequence = ""
        var toppingList = "" //string
        val iceCreamID = radioGroup.checkedRadioButtonId

        if (iceCreamID == -1) {
            //snackbar
            val iceCreamSnackbar =
                Snackbar.make(rootLayout, "Yo, select an ice cream flavor", Snackbar.LENGTH_SHORT)
            iceCreamSnackbar.show()
        } else {
            iceCream = findViewById<RadioButton>(iceCreamID).text

            //checkboxes
            if (checkBox1.isChecked) {
                toppingList += " " + checkBox1.text
            }
            if (checkBox2.isChecked) {
                toppingList += " " + checkBox2.text
            }
            if (checkBox3.isChecked) {
                toppingList += " " + checkBox3.text
            }
            if (checkBox4.isChecked) {
                toppingList += " " + checkBox4.text
            }
            if (toppingList.isNotEmpty()) {
                toppingList = "with" + toppingList
            }

            val location = "at " + spinner.selectedItem

            if (ToGoSwitch.isChecked) {
                iceCream = ToGoSwitch.text.toString() + " $iceCream"
            }

            message = "You'd like a $iceCream Sundae $toppingList $location!"

            updateUI()

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if((requestCode == REQUEST_CODE) && (resultCode==Activity.RESULT_OK)) {
            reviewTextView.setText(data?.let { data.getStringExtra("feedback") })
            feedbackMessage = data?.let { data.getStringExtra("feedback")
        }
    }}

    fun updateUI() {
        flavorButton.text = message
        if (feedbackMessage != null){
            reviewTextView.text = feedbackMessage.toString()}
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("message", message)
        outState.putString("feedback", feedbackMessage.toString())
        super.onSaveInstanceState(outState)
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        message = savedInstanceState.getString("message", "")
        feedbackMessage = savedInstanceState.getString("feedback", "")
        updateUI()
    }

}
