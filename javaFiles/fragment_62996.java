public class C {
    public void test() {
        System.out.println("Inside C");
    }
}

public class B extends C {
    public void test() {
        super.test();
        System.out.println("Inside B");
    }
}

public class A extends B {
    public static void main(String[] args) {
        A obj = new A();
        obj.test();
    }
}