@Configuration
...
public class SpringConfig extends WebMvcConfigurationSupport {
    ...
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        ...
        // add our default method resolver to our ELResolver list.
        JspApplicationContext jspContext = JspFactory.getDefaultFactory().getJspApplicationContext(getServletContext());
        jspContext.addELResolver(new DefaultMethodELResolver(getApplicationContext()));
    }
}