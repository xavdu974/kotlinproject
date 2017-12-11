package com.example.lpsil12.kotlin_project

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Pair
import android.view.View
import android.widget.*
import org.jetbrains.anko.toast

import java.util.ArrayList
import java.util.Arrays
import java.util.concurrent.RecursiveAction

/**
 * Created by lpsil12 on 20/10/2017.
 */


class MySettingsFragment : AppCompatActivity() {

    companion object {

        val name = "defaultName"
        val vibrations = "vibrations"
        val vitesse = "vitesse"
      //  val rate = "rating"
    }

    private var prefName: String by DelegatesExt.preference(this, name, "Votre nom")
    private var prefVib: Boolean by DelegatesExt.preference(this, vibrations, false)
    private var prefVit: Int by DelegatesExt.preference(this, vitesse, -1)
    //private var prefRate: Int by DelegatesExt.preference(this, rate, 0)


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var valider = findViewById(R.id.bt_valider) as Button
        var tv_name = findViewById(R.id.TV_name) as TextView
        var vibrations = findViewById(R.id.SW_vibrations) as Switch
        var vitesse = findViewById(R.id.SB_vitesse) as SeekBar
      //  var bar = findViewById(R.id.ratingBar) as RatingBar

        tv_name.text = prefName
        vibrations.isActivated = prefVib
        vitesse.progress = prefVit
       // bar.rating = prefRate.toFloat()

        valider.setOnClickListener {

            prefName = tv_name.text.toString()
            prefVib = vibrations.isActivated
            prefVit = vitesse.progress
          //  prefRate = bar.rating.toInt()

            toast("Enregistrées ")

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }


    }
}
