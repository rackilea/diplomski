public static void main(String... blah) {
        final TimeoutThread thr = new TimeoutThread(new Runa() {

            @Override
            public Object call() throws Exception {
                while(true) {
                    System.out.println("Yeeee");
                    Thread.sleep(300L);
                }
            }



        }, 500L);

        new Thread() {
            @Override
            public void run() {
                thr.run(); //Call it
            }
        }.start(); //Run it
    }