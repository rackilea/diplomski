@Configuration
public class JobDatabaseConfiguration {

    @Bean
    @JobScope
    public DataSource jobDataSource() throws IOException {

        // set these from job parameters...
        String jdbcUrl = "<your jdbc url>";
        String driver = "<your driver>";
        String user = "user";
        String password = "password";

        return DataSourceBuilder.create()
            .driverClassName(driver)
            .url(jdbcUrl)
            .username(user)
            .password(password)
            build();
    }
}