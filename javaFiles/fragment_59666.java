@Configuration
public class PropertyConfigurer {

    @Bean
    @ConfigurationProperties("props.one")
    private ClientProperties propsOne() {
        return new ClientProperties();
    }

    @Bean
    @ConfigurationProperties("props.two")
    private ClientProperties propsTwo() {
        return new ClientProperties();
    }

    @Bean
    @ConfigurationProperties("props.three")
    private ClientProperties propsThree() {
        return new ClientProperties();
    }
}