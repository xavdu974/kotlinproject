package com.example.lpsil12.kotlin_project

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

/**
 * Created by lpsil12 on 20/10/2017.
 */


class MonFragment : Fragment() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val ft = fragmentManager

        val menu = view.findViewById<View>(R.id.photo) as ImageView
        menu.setOnClickListener {
            activity.fragmentManager.beginTransaction().remove(this@MonFragment).commit()
        }
    }
}
