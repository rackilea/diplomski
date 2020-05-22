@Override
public void run() {
    try {
        while(true) {
            // ... your code here
            Thread.sleep(1000); // this will pause the thread for 1 second
        }
    } catch(InterruptedException e) {
    }
}