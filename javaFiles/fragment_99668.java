@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(initializers = {TestPostgresql.JdbcInitializer.class})
public class TestPostgresql {

    @ClassRule
    public static PostgreSQLContainer postgreSQLContainer = PostgresDbContainer.getInstance();

    /**
     * ************ REPOSITORIES ************
     */
    @Autowired
    NativeQueryRepository nativeQueryRepository;

    static class JdbcInitializer
      implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues.of(
              "spring.datasource.url=" + postgreSQLContainer.getJdbcUrl(),
              "spring.datasource.username=" + postgreSQLContainer.getUsername(),
              "spring.datasource.password=" + postgreSQLContainer.getPassword()
            ).applyTo(configurableApplicationContext.getEnvironment());
        }
    }    
}