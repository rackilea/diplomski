public class ContainerTest {

    private Container container;

    @Before
    public void before() {
        container = new Container(); // Initialize container
    }

    @Test
    public void shouldAddValue() {
        container.addValue("test_value");
        assertTrue(container.getValues().contains("test_value"));
    }

}