public class B {
     public void bMethod(Method method) {
          try {
              method.invoke(null)
          }
          catch (Exception e) {
              throw new RuntimeException(e);
          }
     }
}