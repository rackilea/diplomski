Bean
public SpringTemplateEngine templateEngine() {
   SpringTemplateEngine engine = new SpringTemplateEngine();
   engine.setTemplateResolver(templateResolver());
   engine.addDialect(new SpringSecurityDialect());
   return engine;
}