thread1.start();
thread2.start();
thread3.start();
thread4.start();

thread1.join();
thread2.join();
thread3.join();
thread4.join();

if(exit && exit2 && exit3 && exit4) {
    System.out.println("Program Ended");
}