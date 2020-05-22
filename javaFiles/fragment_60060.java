// We want to start just 2 threads at the same time, but let's control that 
// timing from the main thread. That's why we have 3 "parties" instead of 2.
final CyclicBarrier gate = new CyclicBarrier(3);

Thread t1 = new Thread(){
    public void run(){
        gate.await();
        //do stuff    
    }};
Thread t2 = new Thread(){
    public void run(){
        gate.await();
        //do stuff    
    }};

t1.start();
t2.start();

// At this point, t1 and t2 are blocking on the gate. 
// Since we gave "3" as the argument, gate is not opened yet.
// Now if we block on the gate from the main thread, it will open
// and all threads will start to do stuff!

gate.await();
System.out.println("all threads started");