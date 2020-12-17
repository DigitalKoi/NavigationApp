package com.digitalkoi.navigationapp

import android.content.Context
import androidx.navigation.NavController
import com.digitalkoi.commons.navigation.di.DaggerNavigationComponent
import com.digitalkoi.commons.navigation.di.NavigationComponent
import com.digitalkoi.commons.navigation.di.NavigationModule
import com.digitalkoi.navigationapp.di.DaggerAppComponent
import com.google.android.play.core.splitcompat.SplitCompatApplication
import timber.log.Timber

/**
 * Base class for maintaining global application state.
 *
 * @see SplitCompatApplication
 */
class MainApplication : SplitCompatApplication() {

    lateinit var navigationComponent: NavigationComponent

    lateinit var navController: NavController

    override fun onCreate() {
        super.onCreate()
        initNavigationDependencyInjection()
        initAppDependencyInjection()
        initTimber()
    }

    /**
     * Initialize app dependency injection component.
     */
    private fun initAppDependencyInjection() {
        DaggerAppComponent
            .builder()
            .navigationComponent(navigationComponent)
            .build()
            .inject(this)
    }
    /**
     * Initialize navigation dependency injection component.
     */
    private fun initNavigationDependencyInjection() {
        navigationComponent = DaggerNavigationComponent
            .builder()
            .navigationModule(NavigationModule(navController))
            .build()
    }
    /**
     * Initialize log library Timber only on debug build.
     */
    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }



    companion object {

        /**
         * Obtain navigation dagger component.
         *
         * @param context The application context
         */
        @JvmStatic
        fun navigationComponent(context: Context) =
            (context.applicationContext as? MainApplication)?.navigationComponent
    }
}