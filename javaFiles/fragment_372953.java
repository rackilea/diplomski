@Configuration
public class MyDBConfiguration {

    @Bean(name = "myProjectDataSource")
    @ConfigurationProperties(prefix = "myproject.db")
    public DataSource dataSource(){
        //This will activate Hikari to create a new DataSource instance with all parameters you defined with 'myproject.db'
        return DataSourceBuilder.create().build();
    }
}