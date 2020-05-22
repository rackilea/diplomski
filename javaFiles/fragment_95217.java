@ContextConfiguration(loader = SpringApplicationContextLoader.class, classes = MyServer.class)
@WebAppConfiguration
@IntegrationTest
class MyTestSpec extends Specification {
    …
}