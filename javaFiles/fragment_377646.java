@EnableSpringHttpSession
class HttpSessionConfig {

    @Bean
    MapSessionRepository sessionRepository() {
        return new MapSessionRepository();
    }

    @Bean
    HttpSessionStrategy httpSessionStrategy() {
        return new HeaderHttpSessionStrategy();
    }
}