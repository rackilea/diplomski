@Configuration
public class WebConfigurer implements EmbeddedServletContainerCustomizer {

/**
 * Set up Mime types.
 */
@Override
public void customize(ConfigurableEmbeddedServletContainer container) {
    MimeMappings mappings = new MimeMappings(MimeMappings.DEFAULT);
    // IE issue, see https://github.com/jhipster/generator-jhipster/pull/711
    mappings.add("html", "text/html;charset=utf-8");
    // CloudFoundry issue, see https://github.com/cloudfoundry/gorouter/issues/64
    mappings.add("json", "text/html;charset=utf-8");

    mappings.add("pdf", "application/pdf");

    container.setMimeMappings(mappings);
}

  ....
}

// Register static resources
@Configuration
public class AppMvcConfiguration extends WebMvcConfigurerAdapter {

@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {
  // Including all static resources.

  registry.addResourceHandler("/assets/**", 
              "/css/**", 
              "/img/**",
              "/js/**",
              "/pdf/**"
         ).addResourceLocations("/assets/",
              "/css/", 
              "/img/",
              "/js/",
              "/pdf/**"
  ).resourceChain(true)
   .addResolver(new PathResourceResolver());

   super.addResourceHandlers(registry);