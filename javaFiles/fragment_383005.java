public class A {
    // not static:
    public int aa[] = new int[5];

    public void computeAa() {
        aa[0] = 1;
        aa[1] = 1;

        for (int i = 2; i < aa.length; i++) {
            aa[i] = aa[i - 1] + aa[i - 2];
        }
    }

    public int getAa(int i) {
        return (i < 0) ? 1 : aa[i];
    }
}

public class B extends RecursiveAction {

    private A myA;

    public RecursiveAction(A a) {
        myA = a;
    }

    @Override
    protected void compute() {
        synchronized (myA) {
            // ensure that myA's initialization is complete
            while (myA.aa[0] == 0) {
                // not yet initialized
                myA.wait();
            }
        }
        // ... do something with myA (without modifying it) ...
    }

    public static void main(String[] args) {
       A theA = new A();

       synchronized(theA) {
           // synchronize the initialization of theA, because other threads will
           // check it
           theA.computeAa();

           // wake up any threads waiting on the initialization
           theA.notifyAll();
       }

       List<B> tasks = new ArrayList<B>();

       for(int i = 1; i <= 2; i++){
          //There is 2 fork will created 
            B = new B(theA);
            tasks.add(B);
            B.fork();
        }

        for (B task : tasks) {
            task.join();
        }
    }
}