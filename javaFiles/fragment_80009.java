public class Incremetor extends Runnable {
   Counter counter;

public Incremetor(Counter counter) {
    this.counter = counter;
}
public void run() {
   counter.increment();
}

}

ExecutorService executorService = Executors.newFixedThreadPool(8); // this mean 8 threads in total to do your runnables.
for (int i=0;i<1000;++i) {
     executorService.submit(new Incrementor(counter));        
}