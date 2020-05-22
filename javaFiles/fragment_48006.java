@Bean(name = "dataSource")
 public DriverManagerDataSource dataSource() {
     DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
     driverManagerDataSource.setDriverClassName("org.h2.Driver");
     driverManagerDataSource.setUrl("jdbc:h2:~/test2");
     return driverManagerDataSource;

 }