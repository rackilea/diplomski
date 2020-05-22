public class B extends A {
    private final A a;
    public B(A a) {this.a = a;}
    // delegate all methods of A, i.e.:
    @Override
    public boolean isA() {return a.isA()}

    // add your functionality, e.g.
    public boolean isC() {/* your code here*/}
}