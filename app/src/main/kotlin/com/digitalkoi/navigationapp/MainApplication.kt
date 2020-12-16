package com.digitalkoi.navigationapp

import com.google.android.play.core.splitcompat.SplitCompatApplication
import timber.log.Timber

/**
 * Base class for maintaining global application state.
 *
 * @see SplitCompatApplication
 */
class MainApplication : SplitCompatApplication() {

    override fun onCreate() {
        super.onCreate()
        initTimber()
    }

    /**
     * Initialize log library Timber only on debug build.
     */
    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}