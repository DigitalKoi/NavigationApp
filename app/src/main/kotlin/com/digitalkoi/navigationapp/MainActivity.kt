package com.digitalkoi.navigationapp

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController

/**
 * Base activity class that use the support library action bar features.
 *
 * @see AppCompatActivity
 */
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        (application as MainApplication).navController = findNavController(R.id.nav_host_fragment)
    }
}