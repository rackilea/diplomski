public static void main(String... blah) {
        TimeoutThread thr = new TimeoutThread(new Runa() {

            @Override
            public Object call() throws Exception {
                while(true) {
                    System.out.println("Yeeee");
                    Thread.sleep(300L);
                }
            }



        }, 500L);
        thr.run();
    }