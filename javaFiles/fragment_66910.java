import java.lang.reflect.*;
import java.util.*;

public class Test {
  private final Map<Object, Method> parameterTypeMap = new HashMap<Object, Method>();

  private final Object[] tests = {Double.valueOf(3.1415),
                                  Boolean.TRUE,
                                  new Date(),
                                  new GregorianCalendar(),
                                  new HashMap<Object, Object>()};

  public Test() {
    Method[] methods = Setters.class.getMethods();
    for (Method method : methods) {
      if (method.getName().equals("setCellValue")) {
        Class<?>[] clazzes = method.getParameterTypes();
        if (clazzes.length != 1) {
          continue;
        }
        if (clazzes[0].isPrimitive()) {
          handlePrimitive(method, clazzes[0]);
        }
        parameterTypeMap.put(clazzes[0], method);
      }
    }
  }

  // See http://java.sun.com/javase/6/docs/api/java/lang/Class.html#isPrimitive()
  private void handlePrimitive(Method method, Class<?> clazz) {
    if (clazz == Boolean.TYPE) {
      parameterTypeMap.put(Boolean.class, method);
    } else if (clazz == Double.TYPE) {
      parameterTypeMap.put(Double.class, method);
    } // ... and so on for the other six primitive types (void doesn't matter)
  }

  public void doTests(Setters setter) {
    for (Object test : tests) {
      Method method = findMethodToInvoke(test);
      if (method == null) {
        System.out.println("Nothing found for " + test.getClass());
        continue;
      }

      try {
        method.invoke(setter, test);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  private Method findMethodToInvoke(Object test) {
    Method method = parameterTypeMap.get(test.getClass());
    if (method != null) {
      return method;
    }

    // Look for superclasses
    Class<?> x = test.getClass().getSuperclass();
    while (x != null && x != Object.class) {
      method = parameterTypeMap.get(x);
      if (method != null) {
        return method;
      }
      x = x.getSuperclass();
    }

    // Look for interfaces
    for (Class<?> i : test.getClass().getInterfaces()) {
      method = parameterTypeMap.get(i);
      if (method != null) {
        return method;
      }
    }
    return null;
  }

  public static void main(String[] args) {
    Test test = new Test();
    test.doTests(new Setters());
  }
}

class Setters {
  public void setCellValue(boolean value) {
    System.out.println("boolean " + value);
  }

  public void setCellValue(double value) {
    System.out.println("double " + value);
  }

  public void setCellValue(Calendar value) {
    System.out.println("Calendar " + value);
  }

  public void setCellValue(Date value) {
    System.out.println("Date " + value);
  }

  public void setCellValue(Map<?, ?> value) {
    System.out.println("Map " + value);
  }
}