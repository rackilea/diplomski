public static void main(String[] args) throws InterruptedException {

    Thread main = Thread.currentThread();

    // you have created 4 Thread instances here...
    Threaded t0 = new Threaded();
    Threaded t1 = new Threaded();
    Threaded t2 = new Threaded();
    Threaded t3= new Threaded();

    // you have started t0, t1 and t2 to run on top of main thread
    t0.start();
    t1.start();
    t2.start();

    // here you have used Thread.join()
    // so your main thread will wait here, 
    // it will wait for the completion of t0 
    t0.join();

    // so after the completion of t0, t3 will start
    t3.start();

}