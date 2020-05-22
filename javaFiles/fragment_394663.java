@Bean
VelocityEngine velocityEngine(){
    Properties properties = new Properties();
    properties.load(this.getClass().getResourceAsStream("/application.properties"));
    return new VelocityEngine(properties);
}