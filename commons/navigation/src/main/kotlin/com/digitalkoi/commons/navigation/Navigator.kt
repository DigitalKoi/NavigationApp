package com.digitalkoi.commons.navigation

import androidx.navigation.NavController
import navigation.R

class Navigator(
    private val navController: NavController
) : HomeNavigator, FirstNavigator {


    override fun showFirstScreen() {
        navController.navigate(R.id.)
    }

    override fun showSecondScreen() {
        TODO("Not yet implemented")
    }
}