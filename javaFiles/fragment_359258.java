private static void registerShutdownHook() {
    final Thread mainThread = Thread.currentThread();
    Runtime.getRuntime().addShutdownHook(new Thread() {
        public void run() {
            try {
                System.out.println("Tralala");
                Hellow.setShutdownProcess();
                mainThread.join();
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }

        }
    });  
}