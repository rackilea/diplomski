new Thread(new Runnable() {
        @Override
        public void run() {
            service.shutdown();
            try { service.awaitTermination(10, TimeUnit.DAYS); } catch (InterruptedException e) { }
            System.out.println("All finished");
        }
    }).start();