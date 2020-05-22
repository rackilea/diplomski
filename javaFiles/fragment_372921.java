@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(YourApplication.class)
@TestPropertySource(properties = "logging.level.org.springframework.security:DEBUG")
public class YourApplicationTests {
    // …
}