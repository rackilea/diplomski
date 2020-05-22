import javax.naming.*;
import javax.management.MBeanInfo;
import weblogic.jndi.Environment;
import weblogic.management.runtime.ServerRuntimeMBean;
import weblogic.security.providers.authentication.DefaultAuthenticatorMBean;
import weblogic.management.security.authentication.UserReaderMBean;
import weblogic.management.security.authentication.GroupReaderMBean;
import weblogic.management.MBeanHome;
import weblogic.management.WebLogicMBean;
import weblogic.management.tools.Info;
import weblogic.management.Helper;
import weblogic.management.security.authentication.*;

public class ListUsersAndGroups
{
  public static void main(String[] args)
  {

  MBeanHome home = null;
  try
  {

    Environment env = new Environment();
    env.setProviderUrl(“t3://localhost:7001?);
    env.setSecurityPrincipal(“weblogic”);
    env.setSecurityCredentials(“weblogic”);
    Context ctx = env.getInitialContext();

    home = (MBeanHome)ctx.lookup(“weblogic.management.adminhome”);

    weblogic.management.security.RealmMBean rmBean = 
   home.getActiveDomain().getSecurityConfiguration().getDefaultRealm();

    AuthenticationProviderMBean[] authenticationBeans = 
    rmBean.getAuthenticationProviders();
    DefaultAuthenticatorMBean defaultAuthenticationMBean = 
    (DefaultAuthenticatorMBean)authenticationBeans[0];
    UserReaderMBean userReaderMBean = 
    (UserReaderMBean)defaultAuthenticationMBean;

    String userCurName = userReaderMBean.listUsers(“*”, 100);

    while (userReaderMBean.haveCurrent(userCurName) )
    {
      String user = userReaderMBean.getCurrentName(userCurName);
      System.out.println(“\n User: ” + user);
      userReaderMBean.advance(userCurName);
    }

  }
  catch (Exception e)
  {
    e.printStackTrace();
  }
  }
}