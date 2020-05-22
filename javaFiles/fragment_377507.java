@Bean
public ViewResolver viewResolver() {
    ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
    templateResolver.setTemplateMode("HTML5");
    templateResolver.setPrefix("/WEB-INF/html/");
    templateResolver.setSuffix(".html");

    SpringTemplateEngine engine = new SpringTemplateEngine();
    engine.setTemplateResolver(templateResolver);

    ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
    viewResolver.setTemplateEngine(engine);

    return viewResolver;
}