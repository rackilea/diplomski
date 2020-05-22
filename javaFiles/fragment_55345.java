$cat InvokeMethod.java  
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

public class InvokeMethod {

    public static void invokeMethod( Method m , Object o ,  Object ... args )  
    throws IllegalAccessException, 
           InvocationTargetException {

        m.invoke( o, args );

    }

    public static void main( String [] args ) 
    throws NoSuchMethodException,
           IllegalAccessException,
           InvocationTargetException {

         SomeObject object = new SomeObject();
         Method method = object.getClass().getDeclaredMethod( "someMethod",  String.class );
         invokeMethod( method, object, "World");

    }
}

class SomeObject {
    public void someMethod( String name ){
        System.out.println( "    Hello " + name );
    }
}
$javac InvokeMethod.java 
$java InvokeMethod
Hello World
$