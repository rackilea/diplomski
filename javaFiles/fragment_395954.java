@Bean
public EmbeddedServletContainerFactory servletContainer() {
    TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
    tomcat.addContextCustomizers(new TomcatContextCustomizer() {

        @Override
        public void customize(Context context) {
            if (context.getManager() instanceof StandardManager) {
                // print local path name
                System.out.println(((StandardManager) context.getManager()).getPathname());
            }
        }
    });
    return tomcat;
}