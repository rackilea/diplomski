public class A {

    public static boolean isFromAClass = false;
    B obj = null;

    public A() {
        try {
            isFromAClass = true;
            obj = new B();
            isFromAClass = false;
        } catch (Exception e) {
        }
    }

    public void methodA() {
        System.out.println("methodA");
        obj.methodB();
    }
    // other methods
}

public class B {

    public B () throws Exception {
        if(!A.isFromAClass) {
            throw new Exception();
        }
    }
    public void methodB() {
        System.out.println("methodB");
        // some logic
    }
    //other methods
}

public class Client {

    public static void main(String s[]) throws Exception {
        // Valid Call
        A obj = new A();
        obj.methodA();  // Since methodB is called internally

        // Invalid Call , How to restrict this B object creation here ?
        B objB = new B(); // this line throws Exception
        objB.methodB();

    }
}