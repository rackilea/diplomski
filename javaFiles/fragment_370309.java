public class JourneyStoreApplication extends Application {

    private final JourneyStoreViewModelFactory journeyStoreViewModelFactory;

    {
        // Instantiate my viewmodel factory with my repo here
        final JourneyRepository journeyRepository = new JourneyRepositoryImpl();
        journeyStoreViewModelFactory = new JourneyStoreViewModelFactory(journeyRepository);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public JourneyStoreViewModelFactory getViewModelFactory(){
        return journeyStoreViewModelFactory;
    }
}