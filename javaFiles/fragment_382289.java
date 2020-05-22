public class A {
    public static void doSth() {
        System.out.println("A");
    }
}

public class B {
    public static void doSth() {
        System.out.println("B");
    }
}

public class C {
    public static void doSth() {
        System.out.println("C");
    }
}

public class Sample {

    public static void main(String[] args) {

        Runnable[] methods = { A::doSth, B::doSth, C::doSth };

        int controlVariable = 2;

        methods[controlVariable].run(); // C
    }
}