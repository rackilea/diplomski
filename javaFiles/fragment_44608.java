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
    @TestClock("2015-05-05T10:00:00Z")
    static class Config {
    }

}