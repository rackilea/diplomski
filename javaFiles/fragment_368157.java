@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("indexPage.html");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

}