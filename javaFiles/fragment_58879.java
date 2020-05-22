Thread t1 = new Thread(producer);
Thread t2 = new Thread(producer);
Thread t3 = new Thread(consumer);
Thread t4 = new Thread(consumer);

t1.start();
t2.start();
t3.start();
t4.start();