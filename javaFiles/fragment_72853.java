SortThread t1 = new SortThread(a);  
t1.start(); // <-- you probably want to start before you join.
SortThread t2 = new SortThread(b);
t2.start();  
t1.join();
t2.join();
MergeThread m = new MergeThread(t1.get(),t2.get());
m.start();
m.join();