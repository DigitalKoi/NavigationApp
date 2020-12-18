package com.digitalkoi.commons.ui.extensions

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.digitalkoi.libraries.testutils.TestFragment
import com.digitalkoi.libraries.testutils.robolectric.TestRobolectric
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert.assertEquals
import org.junit.Test

class FragmentExtensionsTest : TestRobolectric() {

    private class TestViewModel(val state: Lifecycle.State? = null) : ViewModel()

    @Test
    fun providedViewModel_ShouldObtainWithStateSaved() {
        val fragmentScenario = launchFragmentInContainer<TestFragment>()
        val expectedState = Lifecycle.State.INITIALIZED

        fragmentScenario.onFragment {
            val createdViewModel = it.viewModel {
                TestViewModel(
                    expectedState
                )
            }
            assertThat(createdViewModel, instanceOf(TestViewModel::class.java))
            assertEquals(expectedState, createdViewModel.state)

            val providedViewModel = ViewModelProvider(it).get(TestViewModel::class.java)
            assertThat(providedViewModel, instanceOf(TestViewModel::class.java))
            assertEquals(expectedState, providedViewModel.state)
        }
    }

    @Test
    fun providedViewModelByIdentifier_ShouldObtainWithStateSaved() {
        val fragmentScenario = launchFragmentInContainer<TestFragment>()
        val expectedState = Lifecycle.State.INITIALIZED
        val identifierViewModel = "TestViewModel"

        fragmentScenario.onFragment {
            val createdViewModel =
                it.viewModel(identifierViewModel) {
                    TestViewModel(
                        expectedState
                    )
                }
            assertThat(createdViewModel, instanceOf(TestViewModel::class.java))
            assertEquals(expectedState, createdViewModel.state)

            val providedViewModel =
                ViewModelProvider(it).get(identifierViewModel, TestViewModel::class.java)
            assertThat(providedViewModel, instanceOf(TestViewModel::class.java))
            assertEquals(expectedState, providedViewModel.state)
        }
    }

    @Test(expected = RuntimeException::class)
    fun providedViewModelWithWrongIdentifier_ShouldNotObtain() {
        val fragmentScenario = launchFragmentInContainer<TestFragment>()
        val identifierViewModel = "TestViewModel"

        fragmentScenario.onFragment {
            it.viewModel(identifierViewModel) { TestViewModel() }
            ViewModelProvider(it).get("Wrong Identifier", TestViewModel::class.java)
        }
    }

    @Test(expected = RuntimeException::class)
    fun notProvidedViewModel_ShouldNotObtain() {
        val fragmentScenario = launchFragmentInContainer<TestFragment>()

        fragmentScenario.onFragment {
            ViewModelProvider(it).get(TestViewModel::class.java)
        }
    }
}
