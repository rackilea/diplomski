public abstract class MyClass
{    
String name="John";

 String getName()
   {
      return name;
  }

}

class NewClass extends Myclass{
   //inside method 
   new NewClass().getName();
}