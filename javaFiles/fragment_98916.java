@InjectMocks
private Subject subject;

@Mock
private AutowireInTest mockAutowizeInTest;

@Before
public void prepare() {
    MockitoAnnotations.initMocks(this);
}