@Configuration
public class DataAccessConfiguration {

    @Bean(destroyMethod = "close")
    public javax.sql.DataSource dataSource() {
        org.apache.tomcat.jdbc.pool.DataSource ds = new org.apache.tomcat.jdbc.pool.DataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost/db");
        ds.setUsername("javauser");
        ds.setPassword("");
        ds.setInitialSize(5);
        ds.setMaxActive(10);
        ds.setMaxIdle(5);
        ds.setMinIdle(2);
        ds.get
        return ds;
    }

}