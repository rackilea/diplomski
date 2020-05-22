import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;

public class CallFoo {
  public static void main(String args[]) throws Exception {
     doCallFoo();
  }

 public static void doCallFoo() throws IllegalAccessException, ClassNotFoundException, NoSuchMethodException, 
         InvocationTargetException, InstantiationException, PrivilegedActionException {
       Class fooClass = Class.forName("Foo");
     final Foo foo = (Foo) fooClass.newInstance();
     final Method helloMethod = fooClass.getDeclaredMethod("hello");

     AccessController.doPrivileged(new PrivilegedExceptionAction() {
         public Object run() throws Exception {
             if(!helloMethod.isAccessible()) {
                 helloMethod.setAccessible(true);
             }
             helloMethod.invoke(foo);
           return null;
         }
     });
 }
 }