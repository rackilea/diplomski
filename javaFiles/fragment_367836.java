public static void main(String[] args) {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");

    //Spring Container will put the values to User Object, and 
    //here context.getBean("user") will get casted to Person interface
    Person person = (Person)context.getBean("user");

    System.out.println("name of person is : " + person.getPersonName() + 
                    "\nage of person is : " + person.getPersonAge());
    context.close();
}