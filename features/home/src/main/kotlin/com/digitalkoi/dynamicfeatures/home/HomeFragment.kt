package com.digitalkoi.dynamicfeatures.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.digitalkoi.commons.navigation.FirstNavigator
import com.digitalkoi.commons.navigation.HomeNavigator
import com.digitalkoi.dynamicfeatures.home.di.DaggerHomeComponent
import com.digitalkoi.navigationapp.MainApplication
import javax.inject.Inject


class HomeFragment : Fragment(R.layout.fragment_home) {

    @Inject
    lateinit var homeNavigator: HomeNavigator

    @Inject
    lateinit var firstNavigator: FirstNavigator

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onInitDependencyInjection()
        // TODO: 16.12.2020 test nav interfaces
        homeNavigator.showFirstScreen()

        firstNavigator.showSecondScreen()
    }

    /**
     * Initialize dagger injection dependency graph.
     */
    private fun onInitDependencyInjection() {
        DaggerHomeComponent
            .builder()
            .navigationComponent(MainApplication.navigationComponent(requireContext()))
            .build()
            .inject(this)
    }

}