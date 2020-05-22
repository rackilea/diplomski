private static Context getInitialContext() throws NamingException {
    Properties props = new Properties();
    props.put( Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
    props.put( Context.URL_PKG_PREFIXES, "org.jboss.as.naming.interfaces:org.jboss.ejb.client.naming");
    return new InitialContext(props);
}