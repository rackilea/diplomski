@Bean  
public InternalResourceViewResolver viewResolver() {  
InternalResourceViewResolver resolver = new InternalResourceViewResolver();  
    resolver.setPrefix("/WEB-INF/pages/");  
    resolver.setSuffix(".ftl");
    return resolver;  
}