import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class MySpringServletInitializer
        extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {
                MySpringWebApplicationContext.class
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    @Override
    public void onStartup(ServletContext servletContext)
            throws ServletException {
        logger.info("starting up");
        super.onStartup(servletContext);
    }
}