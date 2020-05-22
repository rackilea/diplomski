new Thread(new Runnable() {

                @Override
                public void run() {
    while(whichButtonChosen==null){
    try{
    Thread.sleep(1);
    }catch(InterruptedException e){
    e.printStackTrace();
    }

                }
            }).start();