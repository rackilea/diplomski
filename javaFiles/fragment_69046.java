Thread[] threads = new Thread[6];
threads[0] = new Thread(new MyServer("foo", "bar"));
threads[1] = new Thread(new MyServer("bar", "dog"));
...
for (Thread thread : threads) {
    thread.start();
}