package com.digi.bridge

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Instantiate the RootFragment
        val rootFragment = RootFragment()

        // Add the RootFragment to the container
        supportFragmentManager.beginTransaction()
            .add(R.id.root_container, rootFragment)
            .commit()
    }
}