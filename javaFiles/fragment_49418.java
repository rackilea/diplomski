public Runnable getRunnable() {
    Runnable r1 = ...
    Runnable r2 = ...
    return ()->{
         r1.run();
         r2.run();
    };
}