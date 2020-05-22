new Thread(new Runnable() {
        @Override
        public void run() {
            while(true){
               //in my initial try i didn't add sleep, 
               //and i ended up,turning off the pc,lost this post for a while
                try {
                    Thread.sleep(100); //buy little millieseconds
                } catch (InterruptedException e) {}

                Platform.runLater(()->{
                    primaryStage.toFront();
                    //bring your UI on top of everyone
                });
            }

        }
    }).start();