@Configuration
@AutoConfigureBefore(ServletWebServerFactoryAutoConfiguration.class)
public class ForceTomcatAutoConfiguration {

    @Bean
    TomcatServletWebServerFactory tomcat() {
         return new TomcatServletWebServerFactory();
    }
}