public NewThread() {
    t = new Thread(this, "Thread created by Thread Class.");
    System.out.println("Created by constuctor:" + t);
    // don't start here
}
public void start() {
    // start in another method
    t.start();
}
public void run() {     
    System.out.println("run() method called.");     
}
...

public static void main(String[] args) {
    NewThread nt = new NewThread();
    nt.start();
}