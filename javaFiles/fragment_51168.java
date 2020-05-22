public class AB {
    public static void main(String[] args) {
        B myB = new B();
        myB.printA();
    }
}

public class A {
    public static int getInt() {
        return 4;
    }
}

public class B {
    public void printA() {
        System.out.println(A.getInt()); // output: 4
    }
}