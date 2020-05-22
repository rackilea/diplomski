class ClassA implements Runnable {

    public volatile boolean switchToOther;

    @Override
    public void run() {
        switchToOther = false;
        try {
            method1();
        } catch (InterruptedException e) {
            // Restore the interrupted status
            Thread.currentThread().interrupt();
        }
        if (switchToOther) {
            method2();
        }
    }

    public void method1() throws InterruptedException {
        work();
    }

    public void method2() throws InterruptedException {
        otherWork();
    }
}

class ClassB implements Runnable {

    @Override
    public void run() {
        ClassA a = new ClassA();
        Thread t = new Thread(a);
        t.start();
        if (decideToSwitch()) {
            a.switchToOther = true;
            t.interrupt();
        }
    }
}