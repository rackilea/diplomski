@RunWith(SpringJUnit4ClassRunner.class)
// Inherit config from parent and combine with local 
// static Config class to create a new context
@ContextConfiguration
@DirtiesContext
public class MyTest extends BaseTests {

    @Configuration
    static class Config {
        // No need to define any actual @Bean methods.
        // We only need to add an additional @Configuration
        // class so that we get a new ApplicationContext.
    }
}