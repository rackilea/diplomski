public class ManyThreadsAdd {
    public static AtomicInteger index = new AtomicInteger(0);

    public static void main(String[] args) {
        ManyThreadsAdd myClass = new ManyThreadsAdd();
        Thread thread1 = new Thread(myClass.new RunnableClass());
        Thread thread2 = new Thread(myClass.new RunnableClass());

        thread1.start();
        thread2.start();
    }

    class RunnableClass implements Runnable {
        public void run(){
            synchronized(index){
                while(index.get() < 49){
                    try {
                      Thread.sleep(100);
                      System.out.println(index.get()+"-" +Thread.currentThread());
                      index.incrementAndGet();
                      index.notify();
                      index.wait();
                    } catch (InterruptedException e) {
                      e.printStackTrace();
                    }
                }
            }
        }
    }
}