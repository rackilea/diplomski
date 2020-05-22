@PostConstruct
   public void initialize ()
   {
      try
      {
         myJndiParameter = (String) new javax.naming.InitialContext().lookup(appName + "/" + "my.jndi.parameter.name");
      } catch (NamingException e)
      {
         // Treat exception
      }
   }