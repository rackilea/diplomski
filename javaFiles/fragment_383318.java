public class BeansValidator impelements ContextLoaderListener {
    public void contextInitialized(ServletContextEvent event) {
         if (ApplicationContext.getBeansOfType(BaseCarService.class).isEmpty()) {
               // print log, throw exception, etc 
         }
    }
}