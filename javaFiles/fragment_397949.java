@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, properties = {
  "spring.datasource.url=jdbc:tc:postgresql:12.2:///test?TC_INITSCRIPT=init.sql",
  "spring.datasource.driver-class-name=org.testcontainers.jdbc.ContainerDatabaseDriver"
})
abstract class AbstractIntegrationTestCase {

  public static GenericContainer<?> container = new PostgreSQLContainer<>("postgres:12.2");

  static {
    container.start();
  }

  @Autowired
  protected TestRestTemplate restTemplate;
}