@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext.xml")
public class MyAdviceClassTest {
    @Autowired private MyAdviceClass advice;
    @Mock private MyExternalResource resource;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        advice.setResource(resource);
    }

    @Test
    public void featureTest() {
        // Perform testing
    }
}