public class MyClass implements Callable<String> {
   public String call() {
      //doing something asynchronously, when this process is done
      return "somevalue";
   }
}