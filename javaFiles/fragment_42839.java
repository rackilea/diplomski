import java.lang.reflect.Method;

class B {
  public static void main(String[] args) throws Exception {
    System.setSecurityManager(new SecurityManager());
    Class clazz = A.class;
    Method m = clazz.getDeclaredMethod("method1");
    m.setAccessible(true);
  }
}