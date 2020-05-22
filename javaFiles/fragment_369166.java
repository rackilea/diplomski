@Configuration
@ComponentScan
@IntegrationComponentScan
@EnableIntegration
@PropertySource("classpath:org/springframework/integration/configuration/EnableIntegrationTests.properties")
@ImportResource("classpath:org/springframework/integration/configuration/EnableIntegrationTests-context.xml")
@EnableMessageHistory({"input", "publishedChannel", "annotationTestService*"})
public class ContextConfiguration {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }   

}