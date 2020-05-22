public static void main(final String[] args){
    final ApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("classpath:/aspectContext.xml");
    final Service service = applicationContext.getBean(Service.class);
    service.whack("abc", 123);
}