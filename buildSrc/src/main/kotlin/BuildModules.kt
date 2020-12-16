/**
 * Configuration of build modules
 */
object BuildModules {
    const val APP = ":app"
    const val CORE = ":core"
    const val NAVIGATION = ":navigation"

    object Features {
        // TODO: change how you need
        const val HOME = ":features:home"
    }

    object Commons {
        const val UI = ":commons:ui"
        const val VIEWS = ":commons:views"
    }

    object Libraries {
        const val TEST_UTILS = ":libraries:test_utils"
    }
}
