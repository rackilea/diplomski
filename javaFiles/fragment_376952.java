@ContextConfiguration(classes = Config.class)
public class TestRunner extends AbstractTestNGSpringContextTests {

    @Autowired
    test.Test test;

    @Test
    public void testName() {
        test.test(new PersonId("id"));
    }

}