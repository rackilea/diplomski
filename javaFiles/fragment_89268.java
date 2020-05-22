@Configuration
@Import(FeatureConfig.class)
class AppConfig {
   ...
}

@FeatureConfiguration
class FeatureConfig {
  @Feature
  public MvcDefaultServletHandler defaultHandler() {
    return new MvcDefaultServletHandler();
  }
}