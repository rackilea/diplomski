@Bean
 public EmbeddedServletContainerFactory servletContainer() {
          TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory(){    
          @Override
           protected void postProcessContext(Context context) {

           ...  

           StandardContext sContext = (StandardContext) context;  
           sContext.setAliases( "/files=/home/myuser/files");
          }
       };

       ...

  return tomcat;
}