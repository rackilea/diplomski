public class Test {
    // Create a mock early on, so we can use it for the constructor:
    OtherService otherService = Mockito.mock(OtherService.class);

    // A mock for base service, mockito can create this:
    @Mock BaseService baseService;

    // Create the Child class ourselves with the mock, and
    // the combination of @InjectMocks and @Spy tells mockito to
    // inject the result, but not create it itself.
    @InjectMocks @Spy Child child = new Child(otherService);

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }
}