import java.lang.management.ManagementFactory;
  import java.lang.management.OperatingSystemMXBean;
  import java.lang.reflect.Method;
  import java.lang.reflect.Modifier;

  private static void printUsage() {
   OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
   for (Method method : operatingSystemMXBean.getClass().getDeclaredMethods()) {
   method.setAccessible(true);
  if (method.getName().startsWith("get") 
    && Modifier.isPublic(method.getModifiers())) {
        Object value;
    try {
        value = method.invoke(operatingSystemMXBean);
    } catch (Exception e) {
        value = e;
    }
    System.out.println(method.getName() + " = " + value);
    } 
 }
}