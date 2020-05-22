public static void main(String[] args) throws InterruptedException{

    Thread thread1 = new Thread(new MyRunnable());      
    Thread thread2 = new Thread(delay()); 
    Thread thread3 = new Thread(waiting()); // (initial state)

    thread1.start();
    thread1.join();
    thread2.start();
    thread2.join();
    thread3.start();
    thread3.join();
}