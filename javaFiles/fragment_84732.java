@Configuration
public class MyConfiguration {
    @Bean
    freemarker.template.Configuration freeMarkerConfig() {
       return someConfigBeanInstantiatedHere;
    }
}