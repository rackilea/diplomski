public class A {
    int[] a = new int[1];
}

public class B {
    int a = 0x01020304;
}

public class Test {
    public static void main(String[] args) {
        A a = new B();  
        a.a[0] = 3;
        System.out.println(a.a[0]);
    }
}