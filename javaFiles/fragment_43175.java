abstract class Super {
    Super() {
        doSubStuff();
    }
    abstract void doSubStuff();
}

class Sub extends Super {
    String s = "Hello world";

    void doSubStuff() {
        System.out.println(s);
    }
}

public static void main(String[] args) {
    new Sub();
}