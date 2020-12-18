/**
 * Configuration of build modules
 */
object BuildModules {
    const val APP = ":app"
    const val CORE = ":core"

    object Features {
        const val HOME = ":features:home"
        const val LIST = ":features:list"
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
