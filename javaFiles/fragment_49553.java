public synchronized void placePopcorn () throws InterruptedException { 
        while (true) {
            while (isBinFull) wait(); //Look here, waiting since bin is full
            isBinFull = true;
            System.out.println(Thread.currentThread().getName() + ":"+isBinFull);
            notifyAll ();
            Thread.sleep(500);
        }
    }

    // consumer code
    public synchronized void takePopcorn () throws InterruptedException {
        while (true) {
            while (!isBinFull) wait(); ////Look here, waiting since bin is not full
            isBinFull = false;
            System.out.println(Thread.currentThread().getName() + ":"+isBinFull);
            notifyAll ();
            Thread.sleep(500);
        }
    }