@Configuration
@AutoConfigureBefore(EmbeddedServletContainerAutoConfiguration.class)
public class ForceTomcatAutoConfiguration {

    @Bean
    TomcatEmbeddedServletContainerFactory tomcat() {
         return new TomcatEmbeddedServletContainerFactory();
    }
}