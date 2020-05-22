@Profile("embedded")
@Configuration
public class EmbeddedConfig {

    @Bean
    public TomcatEmbeddedServletContainerFactory tomcatFactory() {
        return new EmbeddedServletContainerFactory();
    }
}