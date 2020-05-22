package test;

import java.net.URI;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.ConsoleAppender;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.ConfigurationFactory;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Order;
import org.apache.logging.log4j.core.config.builder.api.AppenderComponentBuilder;
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilder;
import org.apache.logging.log4j.core.config.builder.api.RootLoggerComponentBuilder;
import org.apache.logging.log4j.core.config.builder.impl.BuiltConfiguration;
import org.apache.logging.log4j.core.config.plugins.Plugin;

@Plugin(name = "CustomConfigurationFactory", category = ConfigurationFactory.CATEGORY)
@Order(0)
public class CustomConfigurationFactory extends ConfigurationFactory {

  private static Configuration createConfiguration(
      final String name, ConfigurationBuilder<BuiltConfiguration> builder) {
    builder.setConfigurationName(name);

    AppenderComponentBuilder appenderBuilder =
        builder
            .newAppender("Stdout", "CONSOLE")
            .addAttribute("target", ConsoleAppender.Target.SYSTEM_OUT);
    appenderBuilder.add(
        builder.newLayout("PatternLayout").addAttribute("pattern", "%level: %msg%n"));
    builder.add(appenderBuilder);

    RootLoggerComponentBuilder rootLoggerBuilder = builder.newRootLogger(Level.DEBUG);
    rootLoggerBuilder.add(builder.newAppenderRef("Stdout"));

    builder.add(rootLoggerBuilder);
    return builder.build();
  }

  @Override
  public Configuration getConfiguration(
      final LoggerContext loggerContext, final ConfigurationSource source) {
    return getConfiguration(loggerContext, source.toString(), null);
  }

  @Override
  public Configuration getConfiguration(
      final LoggerContext loggerContext, final String name, final URI configLocation) {
    ConfigurationBuilder<BuiltConfiguration> builder = newConfigurationBuilder();
    return createConfiguration(name, builder);
  }

  @Override
  protected String[] getSupportedTypes() {
    return new String[] {".code"}; // IMPORTANT
  }
}