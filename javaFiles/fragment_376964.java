class OuterClass {
private int x = 7;

public void makeInner(){
    InnerClass in = new InnerClass();
    in.seeOuter();
}
class InnerClass {
    public void seeOuter() {
        System.out.println("Outer x is " + x);
    }
}
public static void main(String[] args) {
    OuterClass.InnerClass inner = new OuterClass().new InnerClass();
    inner.seeOuter();
}