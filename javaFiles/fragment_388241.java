@RunWith(SpringRunner.class)
@SpringBootTest
public class MyIt {

@MockBean
private RestTemplate restTemplate;

@Autowired
private A a;


@Before
public void setup() {
    initMocks(this);
}

@Test
public void test1() throws IOException {

    given(this.restTemplate.doSomethingInOutsideWorld()).willReturn(custom object);
    a.testA()
   }
}