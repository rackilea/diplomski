@Configuration
public class DatasourceConfiguration {

    @Bean
    public BasicDataSource dataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(""); // you can call your code here 
        ds.setUrl(""); // to get these configuration values
        ds.setUsername("");
        ds.setPassword("");
        return ds;
    }
}