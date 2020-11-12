package com.example.lab8

import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var message: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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

    fun updateUI() {
        messageTextView.text = message
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("message", message)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        message = savedInstanceState.getString("message","")
    }

}
