@Configuration
public class ResourceConfig implements WebMvcConfigurer {

    private static final Log LOG = LogFactory.getLog(ResourceConfig.class);

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        String catalinaHome;
        try {
            catalinaHome = System.getenv("CATALINA_HOME");
        } catch (Exception e) {
            LOG.error(e);
            catalinaHome = "";
        }
        registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resources/", "file:" + catalinaHome + "/myresources/");    
    }
}