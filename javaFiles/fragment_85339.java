final Phaser phaser = new Phaser();

public Runnable getRunnable(){
    return new Runnable(){
        public void run(){
            ..do stuff...
            phaser.arriveAndDeregister();
        }
    };
}
public void doWork(){
    phaser.register();//register self
    for(int i=0 ; i < N; i++){
        phaser.register(); // register this task prior to execution 
        executor.submit( getRunnable());
    }
    phaser.arriveAndAwaitAdvance();
}