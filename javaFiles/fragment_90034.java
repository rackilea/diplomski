import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class TomcatIntegrationTest {
  private static Tomcat t;
  private static final int TOMCAT_PORT = 9999;

  @BeforeClass
  public static void setUp() throws LifecycleException {
    t = new Tomcat();
    t.setBaseDir(".");
    t.setPort(TOMCAT_PORT);
    /* There needs to be a symlink to the current dir named 'webapps' */
    t.addWebapp("/service", "src/main/webapp"); 
    t.init();
    t.start();
  }

  @AfterClass
  public static void shutDownTomcat() throws LifecycleException {
    t.stop();
  }
}