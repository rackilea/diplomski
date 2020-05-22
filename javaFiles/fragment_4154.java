List<Thread> threads = new ArrayList<>();
for (Runnable runnable : runnables) {
    Thread t = new Thread(runnable);
    t.start();
    threads.add(t);
}
// Now everything's running - join all the threads
for (Thread thread : threads) {
     thread.join();
}

// Now you can do whatever you need to after all the
// threads have finished.