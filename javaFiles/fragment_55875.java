public static void main(String[] args){
    final BlockingQueue<Integer> queue = new LinkedBlockingQueue<String>();
    Thread[] threads = new Thread[args.length];
    for (int i = 0; i< args.length; i++){
        Runnable r = new WordCount(args[i], queue);
        threads[i] = new Thread(r);
        threads[i].start();
    }

    // wait for the threads to finish
    for (Thread t : threads) {
        t.join();
    }

    int total = 0;    
    for (Integer value : queue) {
        total += value;
    }
    System.out.println(total);
}