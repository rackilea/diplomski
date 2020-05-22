@SuppressWarnings("resource")
public static void main(String[] args) throws Exception {
    /*To load CamelContext.xml file */
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    CustomResourceLoader customResourceLoader = (CustomResourceLoader) context.getBean("customResourceLoader");

    customResourceLoader.showResourceData();

/*To load the properties file*/ 

    ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(Application.class)
            .properties("spring.config.name:application.properties,sql",
                    "spring.config.location=D:/external/application.properties,D:/external/sql.properties")
            .build().run(args);

    ConfigurableEnvironment environment = applicationContext.getEnvironment();


}