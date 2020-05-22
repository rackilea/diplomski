@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/com/stackoverflow/mokito/exemple/spring.xml"})
public class TestCase {
    @Resource
    @InjectMocks
    private MyService service;

    @Resource
    @Spy
    private MyDao dao;

    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
}