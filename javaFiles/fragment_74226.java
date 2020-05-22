1 import java.util.concurrent.*;
 2 
 3 class An {
 4 
 5  private String foo()
 6  {
 7      return "foo";
 8  }
 9  
10  public static void main(String[] args) {
11      final An an = null;
12      (new Callable<String>() {
13          public String call() {
14              return an.foo();
15          }
16      }).call();
17  }
18 }