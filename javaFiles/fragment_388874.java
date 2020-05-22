package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.plugins.util.PluginManager;

public class Log4j2 {

  private static Logger logger = LogManager.getLogger();

  public static void main(String[] args) {
    logger.info("hello");
  }
}