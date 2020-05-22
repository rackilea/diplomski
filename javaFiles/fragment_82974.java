int myNumThreads = 10;

MyThread[] threads = new MyThread[myNumThreads];
for (int i=0; i<myNumThreads; i++) {
    threads[i] = new MyThread () ;
    threads[i].start();
}
System.out.println(threads[0].getValue());