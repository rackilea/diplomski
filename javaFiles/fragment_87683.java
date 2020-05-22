public class MyContainer<T> {

     public List<String> strings() {
         return Arrays.asList("a", "b");
     }
 }

 MyContainer container = new MyContainer<Integer>();
 List<String> strings = container.strings(); //gives unchecked warning!