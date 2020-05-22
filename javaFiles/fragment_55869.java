@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/test-ctx.xml" } ) 
public class SomeServiceTest {

@Autowired
private MyServletContextAwareService myService;

@Before
public void before(){
            //notice that I had to use relative path because the file is not available in the test project
    MockServletContext mockServletContext = new MockServletContext("file:../<my web project name>/src/main/webapp"); 

    myService.setServletContext(mockServletContext);        
}