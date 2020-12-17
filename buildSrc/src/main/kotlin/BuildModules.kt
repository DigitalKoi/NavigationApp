/**
 * Configuration of build modules
 */
object BuildModules {
    const val APP = ":app"
    const val CORE = ":core"

    object Features {
        // TODO: change how you need
        const val HOME = ":features:home"
    }

    object Commons {
        const val UI = ":commons:ui"
        const val VIEWS = ":commons:views"
        const val NAVIGATION = ":commons:navigation"
    }

    object Libraries {
        const val TEST_UTILS = ":libraries:test_utils"
    }
}
