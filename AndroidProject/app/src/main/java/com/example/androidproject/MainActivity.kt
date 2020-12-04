package com.example.androidproject


// Code used from Lab 8/9
//Android studio documentation for Arrays
//Ben Goldin for the find Array idea and for his help
//https://developer.android.com/reference/android/widget/ImageView for imageView
//Android Developer for things like array and random

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { shareWithFriends()}
    }
    var imageInsults = arrayOf(
            R.drawable.insults1, R.drawable.insults2, R.drawable.insults3,
            R.drawable.insults4, R.drawable.insults5, R.drawable.insults6,
            R.drawable.insults7, R.drawable.insults8, R.drawable.insults9,
            R.drawable.insults10, R.drawable.insults11, R.drawable.insults12,
            R.drawable.insults13, R.drawable.insults14, R.drawable.insults15,
            R.drawable.insults16, R.drawable.insults17,R.drawable.insults18,
            R.drawable.insults19,
    )
    var randomImageInsult: Int = 0


    var imageCompliment = arrayOf(
            R.drawable.compliments1, R.drawable.compliments2, R.drawable.compliments3,
            R.drawable.compliments4, R.drawable.compliments5, R.drawable.compliments6,
            R.drawable.compliments7, R.drawable.compliments8, R.drawable.compliments9,
            R.drawable.compliments10, R.drawable.compliments11, R.drawable.compliments12,
            R.drawable.compliments13, R.drawable.compliments14, R.drawable.compliments15,
            R.drawable.compliments16, R.drawable.compliments17, R.drawable.compliments18,
            R.drawable.compliments19,

            )
    var randomImageCompliment: Int = 0



    var websiteURL:String = ""

    fun shareWithFriends() {

        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, websiteURL)
            type = "text/plain"
        }
        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }



    fun showImage(view: View) {
        var typeOfImage: CharSequence = ""
        val typeOfImageID = radioGroup.checkedRadioButtonId

        randomImageInsult = imageInsults.random()
        randomImageCompliment = imageCompliment.random()

        if (typeOfImageID == -1) {
            val imageSnackBar = Snackbar.make(
                    rootLayout,
                    "Please Select either Insult or Compliment",
                    Snackbar.LENGTH_SHORT
            )
            imageSnackBar.show()

        }
        sendhelpandalotofit()
    }
    fun sendhelpandalotofit(){
        if (radioButton1.isChecked()) {
            toSendimageView.setImageResource(randomImageInsult)
            //toSendimageView.setImageBitmap(randomImageCompliment)
            Log.i("test", randomImageInsult.toString())

            if (randomImageInsult == imageInsults[0]) {
                websiteURL = "https://i.pinimg.com/originals/45/ee/3d/45ee3d07b9a6968598da151bad5a48f5.jpg"
            } else if (randomImageInsult == imageInsults[1]){
                websiteURL = "https://i.pinimg.com/originals/2f/a7/68/2fa76860b007bca0366cbdf42000facc.jpg"
            }else if (randomImageInsult == imageInsults[2]){
                websiteURL = "https://i.pinimg.com/originals/fc/9b/fd/fc9bfd3e4dcf896ad2dbcde6cc7f8205.jpg"
            }else if (randomImageInsult == imageInsults[3]){
                websiteURL = "https://pbs.twimg.com/media/A7mZnl7CAAAfc_K.jpg"
            }else if (randomImageInsult == imageInsults[4]){
                websiteURL = "https://memesfeel.com/wp-content/uploads/2019/08/33-Funny-Comeback-Memes-25.jpg"
            }else if (randomImageInsult == imageInsults[5]){
                websiteURL = "https://i.pinimg.com/564x/e2/30/20/e230206c3edc96d8243cc12f21e9bc86.jpg"
            }else if (randomImageInsult == imageInsults[6]){
                websiteURL = "https://i.pinimg.com/474x/89/dc/1e/89dc1e752a0a572774f82ce6047e531a.jpg"
            }else if (randomImageInsult == imageInsults[7]){
                websiteURL = "https://relatably.com/q/img/insult-quotes-tumblr/ead9c25ade26f8fc6274ab4f70b60ca8.jpg"
            }else if (randomImageInsult == imageInsults[8]){
                websiteURL = "https://i.pinimg.com/originals/ff/c3/67/ffc36742c9a28eafb8516411cafc1d7f.jpg"
            }else if (randomImageInsult == imageInsults[9]){
                websiteURL = "https://i.pinimg.com/474x/db/fe/36/dbfe3625a8cea72d342e52b9a6f34af1.jpg"
            }else if (randomImageInsult == imageInsults[10]){
                websiteURL = "https://i.pinimg.com/474x/9b/db/f1/9bdbf1f6fd2ff4a42a3da20095143f51.jpg"
            }else if (randomImageInsult == imageInsults[11]){
                websiteURL = "https://i.pinimg.com/474x/0c/fa/db/0cfadba5ca19b8cf19a5afd70be4d18a.jpg"
            }else if (randomImageInsult == imageInsults[12]){
                websiteURL = "13. https://i.pinimg.com/564x/94/bd/3c/94bd3c60a72bed8d647c8ab281e4e7eb.jpg"
            } else if (randomImageInsult == imageInsults[13]){
                websiteURL = "https://i.pinimg.com/474x/42/ec/1f/42ec1fc17ccae831a11fc0b9778bd4e9.jpg"
            }else if (randomImageInsult == imageInsults[14]){
                websiteURL = "https://i.pinimg.com/474x/14/4a/ec/144aec1c20c00a6ae81d83ec702afc32.jpg"
            }else if (randomImageInsult == imageInsults[15]){
                websiteURL = "https://i.pinimg.com/474x/a8/05/95/a8059595f996d706d9e006d290ab46d2.jpg"
            }else if (randomImageInsult == imageInsults[16]){
                websiteURL = "https://i.pinimg.com/474x/99/dd/96/99dd96cbea826d83185c1a5abb2270db.jpg"
            }else if (randomImageInsult == imageInsults[17]){
                websiteURL = "https://i.pinimg.com/474x/aa/db/43/aadb4343315abda8584b68ebcfa837d2.jpg"
            }else {(randomImageInsult == imageInsults[18])
                websiteURL = "https://i.pinimg.com/originals/63/2a/2a/632a2a3b3d4e6ecc4e63d12c02bab428.jpg"
            }
        }

        if (radioButton2.isChecked()) {
            toSendimageView.setImageResource(randomImageCompliment)
            Log.i("test", randomImageCompliment.toString())

            if (randomImageCompliment == imageCompliment[0]) {
                websiteURL = "https://www.rd.com/wp-content/uploads/2020/01/ponjk.jpg"
            } else if (randomImageCompliment == imageCompliment[1]) {
                websiteURL = "https://thumbs.dreamstime.com/b/you-pretty-hand-drawn-lettering-doodle-heart-leaves-decoration-cute-funny-compliment-card-print-t-shirt-cup-150787131.jpg"
            } else if (randomImageCompliment == imageCompliment[2]) {
                websiteURL = "https://identityspecialist.files.wordpress.com/2012/04/freecomplimentthumb.jpg"
            } else if (randomImageCompliment == imageCompliment[3]) {
                websiteURL = "https://i.pinimg.com/originals/a0/ca/d2/a0cad2aa60c9b7299db667a7c395f027.jpg"
            } else if (randomImageCompliment == imageCompliment[4]) {
                websiteURL = "https://i.pinimg.com/originals/d5/d7/6f/d5d76ffd9708e9ad8d22b975a6897a9b.jpg"
            } else if (randomImageCompliment == imageCompliment[5]) {
                websiteURL = "https://i.redd.it/kjaldhrdt9o31.jpg"
            } else if (randomImageCompliment == imageCompliment[6]) {
                websiteURL = "https://humansoftumblr.com/wp-content/uploads/2019/11/05-Cheesy-Pick-Up-Lines-rd.com-the-noun-project-760x506.jpg"
            } else if (randomImageCompliment == imageCompliment[7]) {
                websiteURL = "https://quotereel.com/wp-content/uploads/2018/02/Funny-Compliments-6.jpg"
            } else if (randomImageCompliment == imageCompliment[8]) {
                websiteURL = "https://i.pinimg.com/originals/b7/95/ea/b795eab8525dab1777b09bd0f6a8dfda.png"
            } else if (randomImageCompliment == imageCompliment[9]) {
                websiteURL = "https://i.pinimg.com/originals/8b/a6/06/8ba606599b1ad620a602a0a97166fa6a.png"
            } else if (randomImageCompliment == imageCompliment[10]) {
                websiteURL = "https://data.whicdn.com/images/182009281/original.jpg"
            } else if (randomImageCompliment == imageCompliment[11]) {
                websiteURL = "https://i.chzbgr.com/full/6877976576/h34DA6D1B/so-fetching"
            } else if (randomImageCompliment == imageCompliment[12]) {
                websiteURL = "https://images.saymedia-content.com/.image/t_share/MTc0OTkxNTM3MjQxODYwMDY0/funny-and-witty-compliments.jpg"
            } else if (randomImageCompliment == imageCompliment[13]) {
                websiteURL = "https://i.pinimg.com/originals/87/cf/d6/87cfd6fa1340e25b9f2f7b9d8991e9f4.jpg"
            } else if (randomImageCompliment == imageCompliment[14]) {
                websiteURL = "https://i.pinimg.com/originals/35/4f/71/354f71998d17fa3349933dc1bce6b24a.jpg"
            } else if (randomImageCompliment == imageCompliment[15]) {
                websiteURL = "https://i.pinimg.com/originals/7f/95/df/7f95df3ee3d6ca078a66bdad5a8a09fb.jpg"
            } else if (randomImageCompliment == imageCompliment[16]) {
                websiteURL = "https://pbs.twimg.com/profile_images/803061094793248769/CvA4A-Fj_400x400.jpg"
            } else if (randomImageCompliment == imageCompliment[17]) {
                websiteURL = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR4R4TEgjYGlnC8223H2_leu28YReWRLfdaYg&usqp=CAU"
            } else {
                (randomImageCompliment == imageCompliment[18])
                websiteURL = "https://i.pinimg.com/originals/25/7a/6d/257a6d2856c0be4844696ab09dde2a76.jpg"
            }
        }

//        Log.i("help", getString(randomImageCompliment).toString())
//
////
//        Log.i("1", R.drawable.insults1.toString())
//        Log.i("2", R.drawable.insults2.toString())
//        Log.i("3", R.drawable.insults3.toString())
//        Log.i("4", R.drawable.insults4.toString())
//        Log.i("5", R.drawable.insults5.toString())
//        Log.i("6", R.drawable.insults6.toString())
//        Log.i("7", R.drawable.insults7.toString())
//        Log.i("8", R.drawable.insults8.toString())
//        Log.i("9", R.drawable.insults9.toString())
//        Log.i("10", R.drawable.insults10.toString())
//        Log.i("11", R.drawable.insults11.toString())
//        Log.i("12", R.drawable.insults12.toString())
//        Log.i("13", R.drawable.insults13.toString())
//        Log.i("14", R.drawable.insults14.toString())
//        Log.i("15", R.drawable.insults15.toString())
//        Log.i("16", R.drawable.insults16.toString())
//        Log.i("17", R.drawable.insults17.toString())
//        Log.i("18", R.drawable.insults18.toString())
//        Log.i("19", R.drawable.insults19.toString())


//        Log.i("working Web", websiteURL)
//        Log.i("test2", websiteURL)
//        Log.i("imageinsultarray1", imageInsults[0].toString())
//        Log.i("randomImageIMVIEW", randomImageInsult.toString())

    }
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("anything?",randomImageInsult)
        outState.putInt("anything?1",randomImageCompliment)
        super.onSaveInstanceState(outState)
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        randomImageInsult = savedInstanceState.getInt("anything?")
        randomImageCompliment = savedInstanceState.getInt("anything?1", )
        sendhelpandalotofit()
    }

}




