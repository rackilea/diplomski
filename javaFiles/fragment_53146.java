import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

@Bean(name="dataSource")
public DriverManagerDataSource dataSource() {
   DriverManagerDataSource dataSource = new DriverManagerDataSource();
   dataSource.setDriverClassName("org.h2.Driver");
   dataSource.setUrl("jdbc:h2:~/myDB");
   dataSource.setUsername("sa");
   dataSource.setPassword("");

   // schema init
   Resource initSchema = new ClassPathResource("script/schema.sql");
   DatabasePopulator databasePopulator = new ResourceDatabasePopulator(initSchema);
   DatabasePopulatorUtils.execute(databasePopulator, dataSource);

   return dataSource;
}