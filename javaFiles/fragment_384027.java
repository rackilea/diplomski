@SpringBootTest
@RunWith(SpringRunner.class)
public class DemoMvcApplicationTest {
    @Value("${test.value}")
    private String value;

    @Test
    public void propertyHasValidValue() {
        assertThat(value).isEqualTo("TestValue1");
    }

    @Configuration
    public static class EmptyTestContext {}
}