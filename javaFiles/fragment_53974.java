public class YourWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
   // Your other init code here

    protected ApplicationContextInitializer<?>[] getServletApplicationContextInitializers() {
        return new ApplicationContextInitializer[] { new YourApplicationContextInitializer()};
    } 

    protected ApplicationContextInitializer<?>[] getRootApplicationContextInitializers() {
        return new ApplicationContextInitializer[] { new YourApplicationContextInitializer()};
    } 

}