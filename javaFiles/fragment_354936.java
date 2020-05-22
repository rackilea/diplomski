public class A {
    B myB;
    String name = "A";

    public A(int num) {
        this.name += num;
    }

    public void setMyB(B b) {
        this.myB = b;
    }

    public B getMyB() {
        return this.myB;
    }

    public String getName() {
        return this.name;
    }
}

public class B {
    A myA;

    String name = "B";
    public B(int num) {
        this.name += num;
        myA = new A(num);
    }

    public A getMyA() {
        return this.myA;
    }

    public String getName() {
        return this.name;
    }
}