@Bean
public ViewResolver configureViewResolver() {
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setPrefix("/WEB-INF/views/"); // instead of /admin/WEB-INF/views
    viewResolver.setSuffix(".jsp");
    return viewResolver;
}