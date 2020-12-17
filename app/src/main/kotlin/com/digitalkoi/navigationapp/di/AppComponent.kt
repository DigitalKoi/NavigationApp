package com.digitalkoi.navigationapp.di

import com.digitalkoi.commons.navigation.di.NavigationComponent
import com.digitalkoi.navigationapp.MainApplication
import com.digitalkoi.navigationapp.scope.AppScope
import dagger.Component

/**
 * App component that application component's components depend on.
 *
 * @see Component
 */
@AppScope
@Component(
    dependencies = [NavigationComponent::class],
    modules = [AppModule::class]
)
interface AppComponent {

    /**
     * Inject dependencies on application.
     *
     * @param application The main application.
     */
    fun inject(application: MainApplication)
}