import java.lang.reflect.*;
import java.lang.*;

public class ReflectionTest {
 public static void main(String[] args)throws NoSuchMethodException,
 ClassNotFoundException,
 IllegalAccessException,
 InvocationTargetException {
  (Class.forName("XYZ")).getDeclaredMethod("ABC", null).invoke(null,null);
 }
}

class XYZ
{
  public static void ABC()
  {
    System.out.println("Lulz");
  }
}