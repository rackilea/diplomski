@Configuration
    @PropertySource("classpath:application.properties")
    public class DefaultConfiguration {}
    @Configuration
    @PropertySource("classpath:{environment_specific_property_name}.properties")
    public class EnvironmentSpecific{

        @Configuration
        @Import(DefaultConfiguration .class)
        static class Configuration {}

    }