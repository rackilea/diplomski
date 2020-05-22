@Configuration
public class SessionConfig {
    @ConditionalOnProperty(name = "testing", havingValue = "false", matchIfMissing = true)
    @EnableRedisHttpSession
    public static class RedisSessionConfig {
    }

    @ConditionalOnProperty(name = "testing", havingValue = "true")
    @EnableSpringHttpSession
    public static class MapSessionConfig {
        @Bean
        public SessionRepository<ExpiringSession> sessionRepository() {
            return new MapSessionRepository();
        }
    }
}