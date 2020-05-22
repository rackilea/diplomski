@Bean(name = "credit")
public PropertiesFactoryBean mapper() {
    PropertiesFactoryBean bean = new PropertiesFactoryBean();
    bean.setLocation(new ClassPathResource("credit.properties"));
    return bean;
}