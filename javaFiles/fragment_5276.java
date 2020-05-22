@Bean(name = "errors")
public PropertiesFactoryBean mapper() {
    PropertiesFactoryBean bean = new PropertiesFactoryBean();
    bean.setLocation(new ClassPathResource("errors.properties"));
    return bean;
}

@Resource(name = "errors")
private Properties errors;