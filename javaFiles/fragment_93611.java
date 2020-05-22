public void threadR(String f) {

    Runnable greetingsFromFred = new Runnable() {

        @Override
        public void run() {
            for (int i = 1; i < 5; i++) {
                try {
                    System.out.println("Main Thread: " + i + " " + f);
                    Thread.sleep(5000);

                } catch (InterruptedException ex) {
                    System.out.println("Main thread interrupted.");

                }
                System.out.println("Main thread exiting.");
            }
        }
    };

    greetings = new Thread(greetingsFromFred, f);
    greetings.start();
}