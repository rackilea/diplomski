@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("TEST")
public class MyServiceTest {

    @Autowired
    MyService myService;

    @Test
    public void testServiceInitialized() throws Exception {
        // ...
    }