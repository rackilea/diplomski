final Hashtable jndiProperties = new Hashtable();
jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");

try {
    final Context context = new InitialContext(jndiProperties);
    String appName = "";
    String moduleName = "jboss-firstbean";
    String distinctName = "";
    String beanName = "FirstBean";
    String interfaceFullName = "ejb.RemoteFirstBean";
    final String jndi = "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName;
    RemoteFirstBean statelessRemote = (RemoteFirstBean)context.lookup(jndi);
} catch (NamingException ex) {
    System.out.println("problems");
}