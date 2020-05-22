public class ProductionCodeClassTest {

    @Mock
    private DependencyClass dependency;

    @InjectMocks
    private ProductionCodeClass testedInstance;

    @Before
    public void setUp() {
        testedInstance = new ProductionCodeClass();
        MockitoAnnotations.initMocks(this);
    }

}