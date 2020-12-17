package com.digitalkoi.commons.navigation.di

import com.digitalkoi.commons.navigation.FirstNavigator
import com.digitalkoi.commons.navigation.HomeNavigator
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NavigationModule::class
    ]
)
interface NavigationComponent {

    fun provideHomeNavigator(): HomeNavigator

    fun provideFirstNavigator(): FirstNavigator
}