@WebListener
public class Config implements ServletContextListener { 

    @Override 
    public void contextInitialized(ServletContextEvent event) {
        ServletContext servletContext = event.getServletContext(); 
        JspApplicationContext jspContext = JspFactory.getDefaultFactory().getJspApplicationContext(servletContext); 
        jspContext.addELResolver(new YourELResolver()); 
    } 

    // ... 
}