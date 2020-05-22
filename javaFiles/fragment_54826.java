@Bean  
public javax.sql.DataSource dataSource() 
{  
    final DataSource dataSource = new DataSource();
    dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
    dataSource.setUsername("muhiuddin");
    dataSource.setPassword("muhiuddin");
    dataSource.setUrl("jdbc:oracle:thin:@172.19.0.10:1521:db10g");
    dataSource.setMaxIdle(5);
    dataSource.setInitialSize(5);
    return dataSource;
}

@Bean  
public JdbcTemplate jdbcTemplate(final javax.sql.DataSource dataSource) 
{  
    final JdbcTemplate jdbcTemplate= new JdbcTemplate();
    // setDataSource(); // if I call this function then every thing is OK.
    jdbcTemplate.setDataSource(dataSource);
    return jdbcTemplate;
}