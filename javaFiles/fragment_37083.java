public class MyContextLoaderListener extends ContextLoaderListener{
    protected WebApplicationContext createWebApplicationContext(ServletContext sc,
                                                        ApplicationContext parent){
        ApplicationContext javaSEAppContext = AppContextHolder.getAppContext();
        GenericWebApplicationContext context = new GenericWebApplicationContext(servletContext);
        context.setParent(javaSEAppContext);
        return context;
    }
}