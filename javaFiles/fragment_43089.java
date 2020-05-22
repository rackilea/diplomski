public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
    return new Class[] { SecurityConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
    return new Class[] { AppConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
    return new String[] { "/" };
    }
}