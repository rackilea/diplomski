class Foo {
   private static void A() {
     System.out.println("method");
   }

   public static void main(String[] args) {
     A();
   }
}

class A {
  public A() {
    System.out.println("ctor");
  }
}