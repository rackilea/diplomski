@Plugin(name = "CustomConfigurationFactory", category = ConfigurationFactory.CATEGORY)
@Order(50)
public class CustomConfigurationFactory extends ConfigurationFactory {

  private static Configuration createConfiguration(final String name, ConfigurationBuilder<BuiltConfiguration> builder) {
    builder.setConfigurationName(name);

    AppenderComponentBuilder appenderBuilder = builder.newAppender("Stdout", "CONSOLE").
        addAttribute("target", ConsoleAppender.Target.SYSTEM_OUT);
    appenderBuilder.add(builder.newLayout("PatternLayout").
        addAttribute("pattern", "%level: %msg%n"));
    builder.add(appenderBuilder);

    RootLoggerComponentBuilder rootLoggerBuilder = builder.newAsyncRootLogger(Level.DEBUG); // use newAsyncRootLogger instead of newRootLogger 
    rootLoggerBuilder.add(builder.newAppenderRef("Stdout"));

    builder.add(rootLoggerBuilder);
    return builder.build();
  }

  @Override
  public Configuration getConfiguration(final LoggerContext loggerContext, final ConfigurationSource source) {
    return getConfiguration(loggerContext, source.toString(), null);
  }

  @Override
  public Configuration getConfiguration(final LoggerContext loggerContext, final String name, final URI configLocation) {
    ConfigurationBuilder<BuiltConfiguration> builder = newConfigurationBuilder();
    return createConfiguration(name, builder);
  }

  @Override
  protected String[] getSupportedTypes() {
    return new String[]{"*"};
  }
}