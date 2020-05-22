@ContextConfiguration(locations = { "classpath:/path/to/test-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class MyBeanTest {

    @Autowired
    private SomeClass someClass;

    @Test
    public void someClassShouldBehave() {
        ...
    }
}