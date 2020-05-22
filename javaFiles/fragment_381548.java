public static void main(String[] args) throws InterruptedException {     
    Thread tr1 = new Thread1();
    Thread tr2 = new Thread2();
    Thread tr3 = new Thread3();
    tr1.start();
    System.out.println("Thread 1 started");
    tr2.start();
    System.out.println("Thread 2 started");
    tr3.start();      
    System.out.println("Thread 3 started");  
}