@Configuration
class FactoryBeanConfig {
    @Bean
    public FactoryBean(final Environment env) {
        return new MyFactoryBean(env);
    }
}