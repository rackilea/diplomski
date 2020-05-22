@Bean
public AnnotationSessionFactoryBean sessionFactoryBean() {
    AnnotationSessionFactoryBean factory = new AnnotationSessionFactoryBean();
    // set up properties etc.
    return factory;
}

@Bean
public SessionFactory sessionFactory() {
   return (SessionFactory) sessionFactoryBean().getObject();
}