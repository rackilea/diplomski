@Module
public class DgFirebaseSubModule {

public DgFirebaseSubModule() {  }


@Provides
@FirebaseScope
SharedPreferences providesSharedPreferences(Application application) {
return PreferenceManager.getDefaultSharedPreferences(application);
    }

}