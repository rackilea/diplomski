public static final String OIM_HOSTNAME = "oim.hpt.lab";
public static final String OIM_PORT = "14000";
public static final String OIM_PROVIDER_URL = "t3://"+ OIM_HOSTNAME + ":" + OIM_PORT;
public static final String OIM_USERNAME = "tungpt";
public static final String OIM_PASSWORD = "Hpt123456";
public static final String OIM_CLIENT_HOME = "F:/designconsole11gr3/config";
public static final String AUTHWL_PATH = OIM_CLIENT_HOME + "/authwl.conf";

public static void main(String[] args) {
    // TODO Auto-generated method stub
    OIMClient oimClient = null;
    try {
        //Set system properties required for OIMClient
        System.setProperty("java.security.auth.login.config", AUTHWL_PATH);
        System.setProperty("APPSERVER_TYPE", "wls");

        // Create an instance of OIMClient with OIM environment information  
        Hashtable env = new Hashtable();
        env.put(OIMClient.JAVA_NAMING_FACTORY_INITIAL, "weblogic.jndi.WLInitialContextFactory");
        env.put(OIMClient.JAVA_NAMING_PROVIDER_URL, OIM_PROVIDER_URL);
        oimClient = new OIMClient(env);

        // Login to OIM with the approriate credentials
        System.out.println("Login by: "+ OIM_USERNAME);
        oimClient.login(OIM_USERNAME, OIM_PASSWORD.toCharArray());
        System.out.println("Login Done!");
    }catch(Exception e){
        e.printStackTrace();
    }
}