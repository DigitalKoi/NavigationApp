package com.digitalkoi.commons.navigation.di

import androidx.navigation.NavController
import com.digitalkoi.commons.navigation.FirstNavigator
import com.digitalkoi.commons.navigation.HomeNavigator
import com.digitalkoi.commons.navigation.Navigator
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NavigationModule(private val navController: NavController) {

    @Singleton
    @Provides
    fun provideNavigator() = Navigator(navController)

    @Singleton
    @Provides
    fun provideHomeNavigator(navigator: Navigator) = navigator as HomeNavigator

    @Singleton
    @Provides
    fun provideFirstNavigator(navigator: Navigator) = navigator as FirstNavigator
}