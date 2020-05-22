public class ProductionCodeClassTest {

    @Mock
    private DependencyClass dependency;

    private ProductionCodeClass testedInstance;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        testedInstance = new ProductionCodeClass(dependency);
    }

}