@Override
public void run() {
    while (true) {
        try {
            Thread.sleep(5000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // the lock is set here
        methodA();
       // and that is released here
    }
}