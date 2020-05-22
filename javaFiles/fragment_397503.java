@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/test-applicationContext-config.xml")
@TestExecutionListeners({ 
    WebContextTestExecutionListener.class, 
    DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class })
public class SpringExampleTest {

    @Rule
    public PowerMockRule rule = new PowerMockRule();

}