@Component
public class MyTest
{
   @Value(${myProperty})
   private String myValue;

   // ... Test methods which can use myValue ...
}