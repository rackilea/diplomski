import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
        new ClassPathXmlApplicationContext("jobs-context.xml");
    }
}