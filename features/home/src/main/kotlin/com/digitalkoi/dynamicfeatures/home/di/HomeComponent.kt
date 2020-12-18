package com.digitalkoi.dynamicfeatures.home.di

import com.digitalkoi.commons.navigation.di.NavigationComponent
import com.digitalkoi.dynamicfeatures.home.HomeFragment
import com.digitalkoi.navigationapp.scope.FeatureScope
import dagger.Component


@FeatureScope
@Component(
//    modules = [HomeModule::class],
    dependencies = [NavigationComponent::class]
)
interface HomeComponent {
    fun inject(fragment: HomeFragment)
}