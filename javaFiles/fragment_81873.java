// Private constructor is only accessible within the class.
class MySingleton private constructor(context: Context) : MySuperClass(context) {
    companion object {
        lateinit var INSTANCE: MySingleton
            // Instance setter is only accessible from within the class.
            private set

        // Custom init function is called from outside and replaces
        // THE WHOLE SINGLETON with a new instance
        // to avoid internal dependencies on the old context.
        fun init(context: Context) {
            INSTANCE = MySingleton(context.applicationContext)
        }
    }

    // Lazily initialized field dependent on a Context instance.
    val prefs by lazy { PreferenceManager.getDefaultSharedPreferences(context) }
}