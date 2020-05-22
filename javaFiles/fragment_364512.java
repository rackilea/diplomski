public class MyThread implements Runnable {

    private MyThreadInvocation  threadInvocation    = null;

    public MyThread(MyThreadInvocation threadInvocation) {
        this.threadInvocation = threadInvocation;
    }

    @Override
    public void run() {
        System.out.println("Calling from : " + Thread.currentThread().getName());
        this.threadInvocation.printMessage();
    }
}


public class MyThreadInvocation {
    public void printMessage(){
        System.out.println("Hello");
    }

    public static void main(String[] args) {
        MyThreadInvocation myThreadInvocation = new MyThreadInvocation();
        Thread t1 = new Thread(new MyThread(myThreadInvocation));
        t1.setName("First Thread");

        Thread t2 = new Thread(new MyThread(myThreadInvocation));
        t2.setName("Second Thread");

        Thread t3 = new Thread(new MyThread(myThreadInvocation));
        t3.setName("Third Thread");

        t1.start();
        t2.start();
        t3.start();
    }
}