package com.example;

public class EnvironmentPostProcessorExample implements EnvironmentPostProcessor {

  private final PropertiesPropertySourceLoader loader = new PropertiesPropertySourceLoader();

  @Override
  public void postProcessEnvironment(ConfigurableEnvironment environment,
                                     SpringApplication application) {
    Resource path = new ClassPathResource("custom.properties");
    // ^^^ here you can create the resource however you want
    // construct the name from a user name, use FileSystemResource, anything
    // for example you can ask users to place a file in their home 
    // directory named "my-application.properties" and load it like so

    // Resource path = new FileSystemResource(Paths.get(System.getProperty("user.home"),"my-application.properties").toString());

    PropertySource<?> propertySource = loadProps(path);
    environment.getPropertySources().addFirst(propertySource);
  }

  private PropertySource<?> loadProps(Resource path) {
    if (!path.exists()) {
      throw new IllegalArgumentException("Resource " + path + " does not exist");
    }
    try {
      return this.loader.load("custom-resource", path, null);
    }
    catch (IOException ex) {
      throw new IllegalStateException(
          "Failed to load props configuration from " + path, ex);
    }
  }

}