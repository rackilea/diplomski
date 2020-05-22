Properties properties = new Properties();
properties.put("java.naming.factory.initial","org.jnp.interfaces.NamingContextFactory");
properties.put("java.naming.factory.url.pkgs","=org.jboss.naming:org.jnp.interfaces");
properties.put("java.naming.provider.url","localhost:1099");

Context context = new InitialContext(properties);
(EchoBeanRemote) c.lookup("EchoBean/remote");