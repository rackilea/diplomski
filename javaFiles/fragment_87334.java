@Module
class ApplicationModule(private val localisationComponent: LocalisationComponent,
                        private val configurationComponent: ConfigurationComponent) {
    @Provides
    @ApplicationScope
    fun providesLocalisationRepository(): LocalisationRepository {
        return localisationComponent.localisationRepository() // Provided by Localisation module with Dagger
    }

    @Provides
    @ApplicationScope
    fun providesConfigurationRepository(): ConfigurationRepository {
        return configurationComponent.configurationRepository() // Provided by Configuration module with Dagger
    }
}