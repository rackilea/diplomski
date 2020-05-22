@Profile("test")
@Configuration
public class H2Config {

    @Autowired
    private DataSource datasource;

    @PostConstruct
    public void loadSQL() throws Exception {
        ScriptUtils.executeSqlScript(datasource.getConnection(), new ClassPathResource("/sql/load_database.sql"));
    }
}