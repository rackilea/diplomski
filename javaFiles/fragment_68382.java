package your.package.warLauncher;

import java.net.URL;
import java.security.ProtectionDomain;

import org.eclipse.jetty.webapp.WebAppContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JettyServerContext extends WebAppContext {

  private static Logger logger = LoggerFactory.getLogger(JettyServerContext.class);

  protected static final String[] JETTY_PLUS_CONFIGURATION_CLASSES;

  static {
    JETTY_PLUS_CONFIGURATION_CLASSES = new String[7];
    JETTY_PLUS_CONFIGURATION_CLASSES[0] = "org.eclipse.jetty.webapp.WebInfConfiguration";
    JETTY_PLUS_CONFIGURATION_CLASSES[1] = "org.eclipse.jetty.webapp.WebXmlConfiguration";
    JETTY_PLUS_CONFIGURATION_CLASSES[2] = "org.eclipse.jetty.webapp.MetaInfConfiguration";
    JETTY_PLUS_CONFIGURATION_CLASSES[3] = "org.eclipse.jetty.webapp.FragmentConfiguration";
    JETTY_PLUS_CONFIGURATION_CLASSES[4] = "org.eclipse.jetty.plus.webapp.EnvConfiguration";
    JETTY_PLUS_CONFIGURATION_CLASSES[5] = "org.eclipse.jetty.plus.webapp.PlusConfiguration";
    JETTY_PLUS_CONFIGURATION_CLASSES[6] = "org.eclipse.jetty.webapp.JettyWebXmlConfiguration";
  }

  public JettyServerContext() {
    setConfigurationClasses(JETTY_PLUS_CONFIGURATION_CLASSES);
    setContextPath("/");
    setWar(getWarLocation());
  }

  /**
   * Returns the location of the war (a trick, which is necessary for executable
   * wars please see: <a target="_blank" href=
   * "http://uguptablog.blogspot.de/2012/09/embedded-jetty-executable-war-with.html"
   * >Embedded Jetty with executable WAR</a>).
   * 
   * @return The war location.
   */
  protected String getWarLocation() {
    ProtectionDomain protectionDomain = JettyServerContext.class.getProtectionDomain();
    URL location = protectionDomain.getCodeSource().getLocation();
    return location.toExternalForm();
  }
}