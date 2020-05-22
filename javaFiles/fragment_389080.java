public class GenericsTest<T extends List> {

 3   public T foo() {
 4     T var = (T) new LinkedList();
 5     return var;
 6   }

 8   public static void main(String... argv) {
 9     GenericsTest<ArrayList> gt1 = new GenericsTest<ArrayList>();
10     gt1.foo();
11     System.out.println("Test one okay");
12     ArrayList<?> list = gt1.foo();
13     System.out.println("Test two okay");
14   }

   }