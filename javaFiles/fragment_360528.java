public static void main(String[] args) {
  ApplicationContext context = 
     new ClassPathXmlApplicationContext("spring/spring-context.xml");

  PersonDaoImpl personDaoImpl = context.getBean(PersonDaoImpl.class);
  Person person = personDaoImpl.findPersonById((long) 10);
  System.out.println("person Found "+person);
}