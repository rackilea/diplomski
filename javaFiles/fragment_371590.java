Properties env = new Properties();
    env.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.security.jndi.JndiLoginInitialContextFactory"); // depends on your server
    env.setProperty(Context.PROVIDER_URL, "jnp://server.local:1099/");
    env.setProperty(Context.SECURITY_PRINCIPAL, "user"); 
    env.setProperty(Context.SECURITY_CREDENTIALS, "password");
    InitialContext ctx = new InitialContext(env);