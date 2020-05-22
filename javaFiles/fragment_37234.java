for (int i = 0; i < 3; i++) {
        list.add("test" + i);
    }

    Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            synchronized (list) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                list.add("test3");
                // Notify the main thread
                list.notify();
            }
        }
    });

    thread.start();

    synchronized (list) {
        try {
            // wait for the other thread for a specified time to terminate
            // this will temporary release the lock for the second thread.
            list.wait(5000);
        } catch (InterruptedException e) {
            // see above..
            e.printStackTrace();
        }
        System.out.println(list);
    }