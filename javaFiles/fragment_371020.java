@RunWith(SpringRunner.class)
@SpringBootTest
@Import(TestConfiguration.class)
public class DemoApplicationTests {

    @Autowired
    private Engine engine;

    @Test
    public void contextLoads() {
        System.out.println("engine : " + engine.getMsg());
    }

}