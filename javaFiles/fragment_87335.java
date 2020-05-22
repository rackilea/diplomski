class MainApplication : Application() {
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        this.registerDependencies()
    }

    private fun registerDependencies() {
        val coreModule = CoreModule(applicationContext)
        val applicationModule = ApplicationModule(LocalisationModule(coreModule).localisationComponent,
                                ConfigurationModule(coreModule).configurationComponent)

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(applicationModule)
                .build()
    }
}