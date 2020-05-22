Thread1 thread1 = new Thread1();
Thread2 thread2 = new Thread2();

thread1.start();

thread1.join(); // This waits for Thread1 to finish before starting Thread2
thread2.start();