// Here is your class
public class A {
    public void foo(Bar bar){
        System.out.println(bar);
    }
}
// Here is a class with a main that runs foo(Bar) on five threads
public class Demo extends Thread {
    static A sharedA = new A();
    Bar myBar = new Bar();
    public void run() {
        sharedA.foo(myBar);
    }
    public static void main(String args[]) {
        for (int i = 0 ; i != 5 ; i++) {
            (new Demo()).start();
        }
    }
}