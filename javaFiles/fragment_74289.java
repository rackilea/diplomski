public static void main(String[] args) {
    System.out.println("from main thread");
    ThreadWaitEg threadWaitEg = new ThreadWaitEg();
    Runnable runInt = threadWaitEg.new PrintNumber();
    new Thread(runInt).start();
    Runnable runChar = threadWaitEg.new PrintChar();
    new Thread(runChar).start();
    System.out.println(" main thread completes ");
}