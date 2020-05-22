Thread thread1 = new Thread(()->deleteVm("a","b");
Thread thread2 = new Thread(()->deleteVm("c","d");

//START the threads
thread1.start();
thread2.start();