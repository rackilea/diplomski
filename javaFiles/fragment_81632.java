package so7691729;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public class MethodCaller {

  private boolean isCompatible(Method m, Object... args) {
    Class<?>[] parameterTypes = m.getParameterTypes();
    if (parameterTypes.length == args.length) {
      for (int i = 0; i < args.length; i++) {
        if (args[i] != null) {
          if (!parameterTypes[i].isAssignableFrom(args[i].getClass())) {
            // TODO: make primitive types equivalent to their boxed types.
            return false;
          }
        }
      }
    } else {
      // TODO: maybe handle varargs methods here
      return false;
    }
    return true;
  }

  public Object call1(String fullyQualifiedMethodName, Object obj, Object... args) throws ClassNotFoundException, IllegalAccessException,
      InvocationTargetException {
    int lastDot = fullyQualifiedMethodName.lastIndexOf(".");
    String className = fullyQualifiedMethodName.substring(0, lastDot);
    String methodName = fullyQualifiedMethodName.substring(lastDot + 1);
    Class<?> clazz = Class.forName(className);

    for (Class<?> c = clazz; c != null; c = c.getSuperclass()) {
      Set<String> sameNameMethods = Sets.newTreeSet();
      Map<String, Method> compatibleMethods = Maps.newTreeMap();
      for (Method method : c.getDeclaredMethods()) {
        if (method.getName().equals(methodName)) {
          sameNameMethods.add(method.toString());
          if (isCompatible(method, args)) {
            compatibleMethods.put(method.toString(), method);
          }
        }
      }

      if (compatibleMethods.size() > 1) {
        throw new IllegalArgumentException("Multiple candidates: " + compatibleMethods.keySet());
      }
      if (compatibleMethods.size() == 1) {
        return compatibleMethods.values().iterator().next().invoke(obj, args);
      }
      if (!sameNameMethods.isEmpty()) {
        throw new IllegalArgumentException("Incompatible types for " + sameNameMethods);
      }
    }
    throw new IllegalArgumentException("No method found.");
  }

  public Object call(String fullyQualifiedMethodName, Object obj, Object... args) {
    try {
      return call1(fullyQualifiedMethodName, obj, args);
    } catch (ClassNotFoundException e) {
      throw new IllegalArgumentException(e);
    } catch (IllegalAccessException e) {
      throw new IllegalArgumentException(e);
    } catch (InvocationTargetException e) {
      throw new IllegalArgumentException(e);
    }
  }

  public String str(Object obj) {
    return "object " + obj;
  }

  public String str(String str) {
    return "string " + str;
  }

  public int add(int a, int b) {
    return a + b;
  }

  @SuppressWarnings("boxing")
  public int addObj(Integer a, Integer b) {
    return a + b;
  }

  private void assertCallingError(String msg, String methodName, Object obj, Object... args) {
    try {
      call(methodName, obj, args);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals(msg, e.getMessage());
    }
  }

  @SuppressWarnings("boxing")
  @Test
  public void test() {
    MethodCaller dummy = new MethodCaller();
    assertEquals("object 1", call("so7691729.MethodCaller.str", dummy, 1));
    assertCallingError("Multiple candidates: " + //
        "[public java.lang.String so7691729.MethodCaller.str(java.lang.Object), " + //
        "public java.lang.String so7691729.MethodCaller.str(java.lang.String)]", //
        "so7691729.MethodCaller.str", dummy, "str");
    assertCallingError("Incompatible types for [public int so7691729.MethodCaller.add(int,int)]", "so7691729.MethodCaller.add", dummy, 3, 4);
    assertEquals(7, call("so7691729.MethodCaller.addObj", dummy, 3, 4));
    assertCallingError("Incompatible types for [public int so7691729.MethodCaller.addObj(java.lang.Integer,java.lang.Integer)]", "so7691729.MethodCaller.addObj", dummy, "hello", "world");
  }

}