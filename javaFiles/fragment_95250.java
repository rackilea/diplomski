@ContextConfiguration(locations = { "classpath:spring-test-config.xml" })
public class SomeSpringTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private SomeClass someClass;

    @Test
    public void someTest() {
        ...
    }
}