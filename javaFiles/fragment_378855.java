Runnable alarmRunnable = new Runnable() {
        @Override
        public void run() {
            for(int i=600; i>0;i-- ){
                try{
                    Thread.sleep(1000);
                    String cc = ""+i;
                    lab1.setText(cc);
                }
                catch(InterruptedException e){
                    System.out.println("Chyba!");
                }
            }
        }
    };

    Thread t = new Thread(alarmRunnable);
    t.start();