// all the other datasource properties will be applied from "myapp.datasource" except password because you excluded it
@ConfigurationProperties(prefix = "myapp.datasource")
@Bean
@Primary // this will override the datasource autoconfiguration and use your own everywhere
public DataSource dataSource() {
    String password = retrieveMyPasswordSecurely();

    return DataSourceBuilder
        .create()
          .password(password)
        .build();
}