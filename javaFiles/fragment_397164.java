class Parent {

    int i;
}

class ChildA extends Parent {}
class ChildB extends Parent {}

public class Main {

    public static void main(String[] args) {

        Parent p1 = new ChildA();
        Parent p2 = new ChildB();
        p1.i = 3;
        p2.i = 4;
        System.out.println(p1.i); // Output: 3
    }
}