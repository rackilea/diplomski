public class Pair<X,Y> { 
    X value1;
    Y value2;
    public X getValue1() { return value1; }
    public Y getValue2() { return value2; }
    public void setValue1(X x) { value1 = x; }
    public void setValue2(Y y) { value2 = y; }
    // implement equals(), hashCode() as needeed
}