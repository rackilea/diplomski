@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class MyControllerTest {
    @MockBean
    private ServiceA serviceA;

    @Autowired // import through Spring
    private MyController myController;

    @Before
    public void init() {
        when(serviceA.getCurrentUser()).thenReturn(some object);
    }

    @Test
    public void firstTest() {
        myController.handleMessage(); // ---> Throws NPE stating that serviceA is null
    }
}