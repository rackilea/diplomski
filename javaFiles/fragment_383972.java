Map<String,String> jdbcUrlSettings = new HashMap<>();
String jdbcDbUrl = System.getenv("JDBC_DATABASE_URL");
if (null != jdbcDbUrl) {
  jdbcUrlSettings.put("hibernate.connection.url", System.getenv("JDBC_DATABASE_URL"));
}

registry = new StandardServiceRegistryBuilder().
    configure("hibernate.cfg.xml").
    applySettings(jdbcUrlSettings).
    build();