final Properties hibernateProperties() {
    final Properties hibernateProperties = new Properties();

    hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
    hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
    hibernateProperties.setProperty("hibernate.show_sql", "true");

    return hibernateProperties;
}