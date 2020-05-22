class A {
    private int x;

    public A() {
        setX(2);
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }
}

class B extends A {
    private int number = 10;

    @Override        
    public void setX(int x) {
        // set x to the value of number: 10
        super.setX(number);
    }
}

public class Test {
    public static void main(String[] args) {
        B b = new B();
        // b.getX() should be 10, right?
        System.out.println("B.getX() = " + b.getX());
    }
}