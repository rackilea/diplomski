@Bean
public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean() {
    Persistence.createEntityManagerFactory("localContainerEntityForTest");

    LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
    lcemfb.setPersistenceUnitName("localContainerEntityForTest");
    lcemfb.setPackagesToScan("com.mybasepackage");
    lcemfb.setPersistenceXmlLocation("classpath:/META-INF/persistence.xml");

    return lcemfb;
}