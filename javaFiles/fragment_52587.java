final CountDownLatch latch = new CountDownLatch(1);

    // asynchronous thread doing the process
    new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("Doing some process");
            doSomeProcess(); // I tested with a 5 seconds sleep
            latch.countDown();
        }
    }).start();

    // asynchronous thread waiting for the process to finish
    new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("Await");
            try {
                latch.await();
            } catch (InterruptedException ex) {
                Logger.getLogger(Motores.class.getName()).log(Level.SEVERE, null, ex);
            }
            // queuing the done notification into the javafx thread
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Done");
                }
            });
        }
    }).start();