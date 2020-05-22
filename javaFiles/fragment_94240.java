@Configuration
public class AppConfig {
  public @Bean Cache<String, MyObject> cache() {
    return CacheBuilder.newBuilder()
      .maximumSize(1000)
      .softValues()
      .build(cacheLoader);
  }

  // defined elsewhere, maybe in XML
  private @Autowired CacheLoader<String, MyObject> cacheLoader;
}