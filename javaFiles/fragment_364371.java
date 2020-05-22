@EnableSpringHttpSession
@Configuration
public class SpringHttpSessionConfig {
  @Bean
  public MapSessionRepository sessionRepository() {
    return new MapSessionRepository(new ConcurrentHashMap<>());
  }
}