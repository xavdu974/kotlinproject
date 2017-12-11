package com.example.lpsil12.kotlin_project

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.Pair
import android.view.Menu
import android.view.MenuItem
import java.util.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        val toggle = ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.setDrawerListener(toggle)
        toggle.syncState()



        val navigationView = findViewById(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)


        val r = findViewById(R.id.recyclerView) as RecyclerView
        r.layoutManager = LinearLayoutManager(this)

        val characters = Arrays.asList(
                Pair.create("Donut", "Version 1.6"),
                Pair.create("Eclair", "Version 2.1"),
                Pair.create("Lolipop", "Version 5.0"),
                Pair.create("Marshmallow", "Version 6.0"),
                Pair.create("Nougat", "Version 7.0")
        )







    }

    override fun onBackPressed() {
        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        return if (id == R.id.action_settings) {
            //Toast.makeText(this, "Paramètres", Toast.LENGTH_LONG).show()
            /* alert("Ouverture d'une popup grace à la fonction alert de la librairie Anko") {
                 yesButton { toast("Vous avez validé votre choix ") }
                 noButton {}
             }.show()*/

            val intent = Intent(this, MySettingsFragment::class.java)
            startActivity(intent)

            true
        } else super.onOptionsItemSelected(item)

    }

override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        val id = item.itemId
        val ft = fragmentManager.beginTransaction()

        if (id == R.id.nav_camera) {

            ft.replace(R.id.liste_frag, MonFragment())
            ft.commit()

        } else if (id == R.id.nav_share) {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

}


