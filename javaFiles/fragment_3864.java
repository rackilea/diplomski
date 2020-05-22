public abstrac class AbstractITest {    
    @TestConfiguration //important, do not use @Configuration!
    @ConditionalOnProperty(value = "someservice.mock", matchIfMissing = true)
    public static class SomeServiceMockConfig {
        @MockBean
        private SomeService some;
    }
}


@TestPropertySource(properties = "someservice.mock=false")
public class WrapperServiceITest extends AbstractITest {
    //SomeService will not be mocked
}