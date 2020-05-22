class Bar{}

public class Foo{
   public static void main (String [] args){
      Foo main = new Foo(1, new Bar(), "name", "description");
      Foo main2 = new Foo(2, new Bar(), "name");
      Foo main3 = new Foo(3, new Bar(), "name", "description", "otherValues");
      Foo main4 = new Foo(4, new Bar());    
   }

   public Foo(int id, Bar bar, String name, String description) {
      System.out.println("name and description!");
   }

   public Foo(int id, Bar bar, String... values) {
      System.out.println("values!");
   }
}