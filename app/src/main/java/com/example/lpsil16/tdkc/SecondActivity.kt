package com.example.lpsil12.kotlin_project


import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.*
import org.jetbrains.anko.find

/**
 * Created by lpsil12 on 20/10/2017.
 */

class SecondActivity : AppCompatActivity(){

    companion object {

        val name = "defaultName"
        val vibrations = "vibrations"
        val vitesse = "vitesse"
        val switch = "switch"
    }

    private var prefName: String by DelegatesExt.preference(this, name, "rien")
    private var prefVib: Boolean by DelegatesExt.preference(this, vibrations, false)
    private var prefVit: Int by DelegatesExt.preference(this, vitesse, -1)
    private var prefToggle: Boolean by DelegatesExt.preference(this, switch, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second)


    }


}
