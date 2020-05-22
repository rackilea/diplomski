public class ThreadA extends Thread {

    ThreadC threadC;

    public void setThreadC(ThreadC threadC) {
        this.threadC = threadC;
    }

    @Override
    public void run() {
        this.loopIt();
    }

    public void loopIt() {
        Random generator = new Random(); 
        int i, j;
        do {
            try { 
                Thread.sleep(1000);
            } catch (InterruptedException ie) {                
            }
            i=generator.nextInt(100)+1;
            j=generator.nextInt(100)+1;
        } while (i != j);
        threadC.start();
    }

}
public class ThreadB extends Thread {

    ThreadA threadA;
    ThreadC threadC;

    public void setThreadA(ThreadA threadA) {
        this.threadA = threadA;
    }
    public void setThreadC(ThreadC threadC) {
        this.threadC = threadC;
    }

    @Override
    public void run() {
        this.loopIt();
    }

    public void loopIt() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command = null;
        // loop until interrupted
        try {
            while (!this.isInterrupted()) {
                command = reader.readLine();
                if ("a".equals(command)) {   
                    System.out.println("a was entered");
                    if (threadA.getState() == Thread.State.NEW) {
                        threadA.start();
                    }
                } else if ("b".equals(command)) {   
                    System.out.println("b was entered");            
                } else if ("c".equals(command)) {
                    System.out.println("c was entered");
                } else if ("z".equals(command)) {
                    System.out.println("z was entered");
                    throw new InterruptedException("Command z interruption");
                } else {
                    System.out.println("no such command");
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (InterruptedException ie) {
        }
        // Now notify ThreadC - it will wait() until this code is run
        synchronized(threadC) {
            threadC.notify();
        }
    }
}

public class ThreadC extends Thread {

    ThreadB threadB;

    public void setThreadB(ThreadB threadB) {
        this.threadB = threadB;
    }

    @Override
    public void run() {
            this.loopIt();
   }

    public void loopIt() {
        // Block until the lock can be obtained
        // We want thread B to run first, so the lock should be passed into Thread C constructor in an already locked state
        threadB.interrupt();
        synchronized(this) {
            try {
                // Put this thread to sleep until threadB calls threadC.notify().
                //
                // Note: could replace this line with threadB.join() - and remove  
                // from threadB the call to threadC.notify()
                this.wait();
            } catch (InterruptedException ie) {
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String command = null;
            while (!"e".equals(command)) {
                try {
                    command= reader.readLine();
                    if ("d".equals(command)) {   
                        System.out.println("d was entered");             
                    } else if ("e".equals(command)) {    
                        System.out.println("e was entered");            
                    } else if ("f".equals(command)) {
                        System.out.println("f was entered");
                    } else if ("z".equals("command")) {
                        System.out.println("z was entered");
                    } else { 
                        System.out.println("no such command");
                    };
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }        
    }
}