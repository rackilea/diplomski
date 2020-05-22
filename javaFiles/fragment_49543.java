private void CallMultipleToast(){
  Thread t = new Thread(){
        @Override
        public void run(){
            try {
                for(i=0;i<7;i++){
                   Toast("Message "+(i+1));
                   sleep(5000);
                }

            } catch (InterruptedException ex) {
                Log.i("error","thread");
            }
        }
    };
   t.start();
 }