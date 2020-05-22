Hashtable env = new Hashtable();
env.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
env.put("java.naming.provider.url", "jnp://localhost:1099");
env.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
Context ctx = new InitialContext(env); 
// name is whatever JNDI name you gave it 
Object o = ctx.lookup("home name"); 
EJBHome ejbHome = (EJBHome) PortableRemoteObject.narrow(o,EJBHome.class); 
// This is userID should be the one passed. 
EJB ejb = ejbHome.create(..);