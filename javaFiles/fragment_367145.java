import javax.servlet.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException
    { super.onStartup(servletContext); }

    @Override
    protected Class<?>[] getRootConfigClasses()
    { return new Class[]{MyRoot.class};}

    @Override
    protected Class<?>[] getServletConfigClasses()
    { return null; }

    @Override
    protected String[] getServletMappings()
    { return new String[]{"/"}; }

    @Override
    protected String getServletName()
    { return "myDispatcherServlet"; }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration)
    {
        super.customizeRegistration(registration);
        registration.setLoadOnStartup(1);
    }
}