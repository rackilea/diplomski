public static void main(String[] args) throws NamingException {
        Properties jndiProps = new Properties();
        jndiProps.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        jndiProps.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        jndiProps.put("jboss.naming.client.ejb.context", true);
        jndiProps.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
        jndiProps.put(Context.SECURITY_PRINCIPAL, "user");
        jndiProps.put(Context.SECURITY_CREDENTIALS, "xxx");
        Context ctx = new InitialContext(jndiProps);
        MyBeanRemote myBean = (MyBeanRemote) ctx.lookup("/<appname>/<beanname>!<fullqualifiedremoteinterface>");
        myBean.doSomething();
    }