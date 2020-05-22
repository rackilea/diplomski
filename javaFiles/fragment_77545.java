public class Test {
   public <T> void someGenericMethod(Class<T> clazz, Integer a) {
      T t = clazz.cast(a);
      System.out.println(t);
      System.out.println(t.getClass());
   }

   public static void main(String[] args) {
      Test test = new Test();
      // gives a ClassCastException at runtime:
      test.someGenericMethod(BigDecimal.class, 42);
   }
}