import org.springframework.context.support.ClassPathXmlApplicationContext; 

public class SpringApplicationContextExample
{

  public static void main (String[] args)
  {
    new Main();
  }

  public SpringApplicationContextExample()
  {
    // open/read the application context file
    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-Context.xml");

    // retrieve a bean for class SomeSpringService
    SomeSpringService someSpringService = (SomeSpringService)ctx.getBean("someSpringService");

    //do whatever with the bean
  }

}