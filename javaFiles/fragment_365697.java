Thread myThread = new Thread(){

        public void run(){

            try{
                sleep(5000);

            }catch(InterruptedException e){
                e.printStackTrace();

            }finally{
                Intent menuIntent = new Intent("com.kamath.thebasics.MENU");
                startActivity(menuIntent);

            }
        }
    };

    myThread.run();