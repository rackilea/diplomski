@RunWith(SpringRunner.class)
@ContextConfiguration
public class DemoMvcApplicationTest {
    @Value("${test.value}")
    private String value;

    @Test
    public void propertyHasValidValue() {
        assertThat(value).isEqualTo("TestValue1");
    }

    @Configuration
    @PropertySource("classpath:application.properties")
    public static class EmptyTestContext {}
}