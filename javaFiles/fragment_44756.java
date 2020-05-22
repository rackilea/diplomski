import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class SO {
  public void test1() {
        System.out.println("Running test1");
  }
  public void test2() {
        System.out.println("Running test2");
  }
  public void test3() {
        System.out.println("Running test3");
  }
  public void notATest() {
        System.err.println("THIS IS NOT A TEST");
  }

  public static void main(String ... args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    Class c = SO.class;
    SO that = new SO();
    Method[] methods = filter(c.getDeclaredMethods(), "test");
    PermuteMethod permutations = new PermuteMethod(methods);
    while(permutations.hasNext()) {
      for(Method permutation: permutations.next()) {
        permutation.invoke(that, null);
      }
      System.out.println("----");
    }
  }
  private static Method[] filter(Method[] declaredMethods, String startsWith) {
    List<Method> filtered = new ArrayList<>();
    for(Method method : declaredMethods) {
      if(method.getName().startsWith(startsWith)) {
        filtered.add(method);
      }
    }
    return filtered.toArray(new Method[filtered.size()]);
  }
}