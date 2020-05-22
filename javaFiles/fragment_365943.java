public class A {
    public int a;

    public class B {
         public int b;
         // Publish your own accessor
         A enclosing() {
             return A.this;
         }
         public void foo(B other) {
             System.out.println(other.enclosing().a);
             System.out.println(other.b);
         }
    }
}