class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // Eagerly initialized singleton.
        MySingleton.init(this)
    }
}