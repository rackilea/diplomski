Properties p = new Properties();
p.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
final Context context = new InitialContext(p);
final String appName = "YOUR APP NAME";
final String moduleName = "YOUR EJB MODULE NAME";
final String distinctName = "DISTINCT NAME";
final String beanName = "Your bean name";
final String viewClassName = ClienteDAORemote.class.getName();
String path = "ejb:" + appName + "/" + moduleName + "/"
        + distinctName + "/" + beanName + "!" + viewClassName;
Object o = context.lookup(path);
return (RemoteBean) o; //Cast to your remote interface