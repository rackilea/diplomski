@Produces
 public Service produceService() {
   Properties jndiProps = new Properties();
   jndiProps.put(Context.INITIAL_CONTEXT_FACTORY,"org.jboss.naming.remote.client.InitialContextFactory");
   jndiProps.put(Context.PROVIDER_URL,"remote://localhost:4447");
   // create a context passing these properties
   Context ctx = new InitialContext(jndiProps);
   // lookup
   Service service = (Service) ctx.lookup("<jndi name of the ejb>");
   return service;
}