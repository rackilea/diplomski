@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration
public class ExampleTests {

    @Autowired
    private Clock clock;

    @Test
    public void test() throws Exception {
        System.out.println(this.clock);
    }

    @Configuration
    @Import(SampleSimpleApplication.class)
    static class Config {

        @Bean
        @Primary
        public Clock clock() {
            Clock.fixed(...)
        }

    }

}