public class FakeJourneyStoreApplication extends JourneyStoreApplication {

    private final JourneyStoreViewModelFactory fakeJourneyStoreViewModelFactory;

    {   // Create my fake instances here for my tests
        final JourneyRepository fakeJourneyRepository = new FakeJourneyRepositoryImpl();
        fakeJourneyStoreViewModelFactory = new FakeJourneyStoreViewModelFactory(fakeJourneyRepository);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public JourneyStoreViewModelFactory getViewModelFactory(){
        return fakeJourneyStoreViewModelFactory;
    }
}