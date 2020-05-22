public class MyServiceTest {

    private final NetworkBehavior behavior = NetworkBehavior.create();
    private final rx.observers.TestSubscriber<String> testSubscriber = TestSubscriber.create();
    private MyService mockService;

    @Before
    public void setUp() throws Exception {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl("http://example.com").build();

        MockRetrofit mockRetrofit = new MockRetrofit.Builder(retrofit)
                .networkBehavior(behavior).build();

        final BehaviorDelegate<MyService> delegate = mockRetrofit.create(MyService.class);

        mockService = new MyServiceMock(delegate);
    }

    @Test
    public void testSuccessResponse() throws Exception {
        givenNetworkFailurePercentIs(0);

        mockService.name().subscribe(testSubscriber);

        testSubscriber.assertValue("test");
        testSubscriber.assertCompleted();
    }

    @Test
    public void testFailureResponse() throws Exception {
        givenNetworkFailurePercentIs(100);

        mockService.name().subscribe(testSubscriber);

        testSubscriber.assertNoValues();
        testSubscriber.assertError(IOException.class);
    }

    private void givenNetworkFailurePercentIs(int failurePercent) {
        behavior.setDelay(0, MILLISECONDS);
        behavior.setVariancePercent(0);
        behavior.setFailurePercent(failurePercent);
    }
}