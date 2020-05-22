public class Foo {
   public void doSomething() {
       System.out.println("I did something!");
   }
}

public class Bar {
   public static void main(String[] args) {
       Foo foo = new Foo();
       foo.doSomething();
   }
}