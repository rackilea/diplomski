BlockingQueue<T> original = new LinkedBlockingQueue<T>();

Thread consumer1 = new Thread(new Consumer(original));
Thread consumer2 = new Thread(new Consumer(original));

consumer1.start();
consumer2.start();