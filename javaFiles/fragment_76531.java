@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfiguration.class) 
public class MongoServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(MongoServiceTest.class);

    @Autowired
    MongoService mongoService;

    @Test
    public void MongoServiceAutowired() {   
        assertNotNull(mongoService);
    }
}