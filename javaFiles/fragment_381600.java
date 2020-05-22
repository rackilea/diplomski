public class A {

    public static void methodA() {
        B.methodB();
    }

}

public class B {

    public static void methodB() {
        C.methodC();
        int a = 1;
        int b = 2;
        System.out.println( a + b );
    }

}

public class C {

    public static void methodC() {
        D.methodD();
    }

}

public class D {

    public static void methodD() {

    }

}