public class HelloRunnable implements Runnable {
    private MyClass myClass;
    private boolean execMethod1;
    private boolean execMethod2;
    private boolean execMethod3;

public HelloRunnable(MyClass myClass, boolean execMethod1, boolean execMethod2, boolean execMethod3) {
    this.myClass = myClass;
    this.execMethod1 = execMethod1;
    this.execMethod2 = execMethod2;
    this.execMethod3 = execMethod3;
} 
public void run() {
    if(execMethod1) myClass.method1();
    else if(execMethod2) myClass.method2();
    else if(execMethod3) myClass.method3();
}

public static void main(String args[]) {
    MyClass myClass = new MyClass();
    (new Thread(new HelloRunnable(myClass, true, false, false))).start();
    (new Thread(new HelloRunnable(myClass, false, true, false))).start();
    (new Thread(new HelloRunnable(myClass, false, false, true))).start();
}
}