@Configuration
@EnableAutoConfiguration(exclude={
                            SecurityAutoConfiguration.class, 
                            ManagementSecurityAutoConfiguration.class,
                            DataSourceAutoConfiguration.class
                        })
@EnableJpaRepositories(basePackages = "com.example.repository")
public class TestConfig {    
    @Bean
    public String sharedSecret() {
        return null;
    }

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.HSQL)
            .build();
    }
}