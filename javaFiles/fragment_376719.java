Thread[] threads = new Thread[10];
for(int i = 0; i < 10; i++) {
    threads[i] = new Thread(new Runnable() {
                    public void run() {
                        ThreadIceCream tic = new ThreadIceCream();
                    }
                 });
    threads[i].start();
}

for(int i = 0; i < 10; i++) {
    threads[i].join();
}