public class MyClass implements MyClassInterface {
   public Results process(String arg1, String arg2) {
      // does some proceeding, returns Results
   }
   public Callable<Results> bind(String arg1, String arg2) {
      return () -> process(arg1, arg2);
   }
   // Other methods omitted
}