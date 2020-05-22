@Module
public class SharedPrefModule {
    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AtlasPreferencesHelper atlasPreferencesHelper) { 
        return atlasPreferencesHelper;
    }
}