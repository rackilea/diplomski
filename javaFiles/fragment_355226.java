public class TestMyApplication extends MyApplication {

    private TestApplicationComponent testApplicationComponent;

    @Override
    public TestApplicationComponent getOrCreateApplicationComponent() {
        if (testApplicationComponent == null) {
            testApplicationComponent = DaggerTestApplicationComponent
                    .builder()
                    .myAppModule(new MyAppModule(this))
                    .testNetworkModule(new TestNetworkModule())
                    .build();
        }
        return testApplicationComponent;
    }
}