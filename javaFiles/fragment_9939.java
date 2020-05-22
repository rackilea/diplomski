@Bean
public TemplateResolver templateResolver() {
    TemplateResolver resolver = new ServletContextTemplateResolver();
    resolver.setPrefix("/WEB-INF/views/");
    resolver.setSuffix(".html");
    resolver.setCharacterEncoding("UTF-8");
    resolver.setTemplateMode("HTML5");
    resolver.setOrder(2);
    return resolver;
}

@Bean
public TemplateResolver emailTemplateResolver() {
    TemplateResolver resolver = new ClassLoaderTemplateResolver();
    resolver.setPrefix("mail/");
    resolver.setSuffix(".html");
    resolver.setTemplateMode("HTML5");
    resolver.setCharacterEncoding("UTF-8");
    resolver.setOrder(1);
    return resolver;
}

@Bean
public SpringTemplateEngine templateEngine() {
    final SpringTemplateEngine engine = new SpringTemplateEngine();
    final Set<TemplateResolver> templateResolvers = new HashSet<TemplateResolver>();
    templateResolvers.add(emailTemplateResolver());
    templateResolvers.add(templateResolver());
    engine.setTemplateResolvers(templateResolvers);
    return engine;
}