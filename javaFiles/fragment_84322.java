public class OtherClass {
  public void run(Object invokerObject) {
     Class invoker = invokerObject.getClass();
     Field[] fields = invoker.getFields();
     for (int i = 0; i < fields.length; i++) {
       // retrieve info from fields[i]      .
     }
     Method[] methods = invoker.getMethods();
     for (int i = 0; i < methods.length; i++) {
       // retrieve info from methods[i]     .
     }

  }
}