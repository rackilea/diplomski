new Thread(new Runnable() {
        @Override
        public void run() {
             while(true){
                 //here you wait forever doesn't matter the UI thread.
                 if(everythingDone) {//here to add your condition
                      new Handler().post(new Runable() {
                          @Override
                          public void run() {
                               //Here you can do what you want and will be done in UI Thread
                          }
                      });
                 }
             }
        }
}).start();