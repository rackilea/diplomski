@Configuration
public class JpaConfiguration {

@Bean()
public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
    LocalContainerEntityManagerFactoryBean emFactory = new LocalContainerEntityManagerFactoryBean();
    emFactory.setPersistenceProviderClass(FilterEnableHibernatePersistenceProvider.class);
    //yours configuration
}