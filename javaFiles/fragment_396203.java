Properties properties = new Properties();
properties.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
properties.setProperty(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
properties.setProperty(Context.PROVIDER_URL, "localhost:1099");
context = new InitialContext(properties);
SinaRemote sina = (SinaRemote) context.lookup("SinaBean/remote");