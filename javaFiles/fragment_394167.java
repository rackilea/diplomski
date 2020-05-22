@Configuration
public class CustomAwsParamStorePropertySourceLocator implements PropertySourceLocator {

  private static final Logger LOGGER =
      LoggerFactory.getLogger(CustomAwsParamStorePropertySourceLocator.class);

  private AWSSimpleSystemsManagement ssmClient;

  private List<String> contexts = new ArrayList<>();

  public CustomAwsParamStorePropertySourceLocator(AWSSimpleSystemsManagement ssmClient) {
    this.ssmClient = ssmClient;
  }

  public List<String> getContexts() {
    return contexts;
  }

  @Override
  public PropertySource<?> locate(Environment environment) {
    if (!(environment instanceof ConfigurableEnvironment)) {
      return null;
    }

    ConfigurableEnvironment env = (ConfigurableEnvironment) environment;

    List<String> profiles = Arrays.asList(env.getActiveProfiles());

    String defaultAppName = "application";
    this.contexts.add("/" + defaultAppName + "/");
    addProfiles(this.contexts, defaultAppName, profiles);

    String appName = env.getProperty("spring.application.name");
    this.contexts.add("/" + appName + "/");
    addProfiles(this.contexts, appName, profiles);

    Collections.reverse(this.contexts);

    CompositePropertySource composite = new CompositePropertySource("custom-aws-param-store");

    for (String propertySourceContext : this.contexts) {
      try {
        composite.addPropertySource(create(propertySourceContext));
      } catch (Exception e) {
        LOGGER.warn("Unable to load AWS config from " + propertySourceContext, e);
      }
    }

    return composite;
  }

  private void addProfiles(List<String> contexts, String appName, List<String> profiles) {
    for (String profile : profiles) {
      contexts.add("/" + profile + "." + appName + "/");
    }
  }

  private AwsParamStorePropertySource create(String context) {
    AwsParamStorePropertySource propertySource =
        new AwsParamStorePropertySource(context, this.ssmClient);
    propertySource.init();
    return propertySource;
  }
}