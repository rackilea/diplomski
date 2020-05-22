new Thread(new Runnable() {

        @Override
        public void run() {

            while(buttonClicked.getValue() ==0) {
                   // you didn't click

                     Thread.sleep(10000);
            }
       };
}).start();