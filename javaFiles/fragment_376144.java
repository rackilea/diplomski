package ro.derbederos.hlfe.impl.util;

public class MyThreadLocal extends Thread {

private static final ThreadLocal<String> testId = new InheritableThreadLocal<String>();

String testIdString;

public MyThreadLocal(String testId) {
this.testIdString = testId;
}

public void run() {
    int loop = 10;
    testId.set(testIdString);


    for (int i=0;i<loop;i++) {
        System.out.println(this.getName()+" - "+testId.get());
        try {this.sleep(1000);} catch (InterruptedException e) {}
    }
}

public static void main(String args[]) {
    new MyThreadLocal("hello-0").start();
    try {Thread.sleep(1000);} catch (InterruptedException e) {}
    new MyThreadLocal("hello-1").start();
}
}