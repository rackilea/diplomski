abstract class Foo {
    protected int x;
    protected Foo(int x) {this.x = x;}
    public abstract void bar();
}
public static void main (String[] args) {
    Foo foo = new Foo(123) { // <<== This works because of "compiler magic"
        public void bar() {System.out.println("hi "+x);}
    };
    foo.bar();
}