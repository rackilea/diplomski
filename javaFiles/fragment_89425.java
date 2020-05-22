@Bean
public JpaVendorAdapter jpaVendorAdapter() {
    HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
    jpaVendorAdapter.setShowSql(true);
    jpaVendorAdapter.setDatabase(Database.HSQL);
    jpaVendorAdapter.setDatabasePlatform(MySQL5Dialect.class.getName());
    jpaVendorAdapter.setGenerateDdl(false);
    return jpaVendorAdapter;
}