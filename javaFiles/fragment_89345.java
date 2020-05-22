@RunWith(SpringRunner.class)
@SpringBootTest(properties = "server.port=9000",
        classes = Application.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@DirtiesContext(classMode = BEFORE_EACH_TEST_METHOD)
public class TodoWebDriverTest {
  // many test methods
}