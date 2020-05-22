private ITemplateResolver templateResolver() {
    SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
    resolver.setApplicationContext(applicationContext);
    resolver.setPrefix("/templates/"); // Here!!!
    resolver.setSuffix(".html");
    return resolver;
}