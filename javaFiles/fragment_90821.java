import java.util.ArrayList;
import java.lang.reflect.Method;

public class ReflectionTest {

  public static void main(String[] args) {
    try {
      Method onLoaded = SomeClass.class.getMethod("someMethod",  ArrayList.class );
      Method onLoaded2 = SomeClass.class.getMethod("someMethod",  new Class[]{ArrayList.class}  );    

      SomeClass someClass = new SomeClass();
      ArrayList<AW> list = new ArrayList<AW>();
      list.add(new AW());
      list.add(new AW());
      onLoaded.invoke(someClass, list); // List size : 2

      list.add(new AW());
      onLoaded2.invoke(someClass, list); // List size : 3

    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

}

class AW{}

class SomeClass{

  public void someMethod(ArrayList<AW> list) {
    int size = (list != null) ? list.size() : 0;  
    System.out.println("List size : " + size);
  }

}