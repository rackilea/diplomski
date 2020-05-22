mSplashThread =  new Thread(){
        @Override
        public void run(){
            try {
                synchronized(this){
                    // Wait given period of time or exit on touch
                    wait(5000);
                }
            }
            catch(InterruptedException ex){                    
            }


            // Run next activity
            Intent intent = new Intent();
            intent.setClass(sPlashScreen, MainActivity.class);
            startActivity(intent);



            //call finish after startActivity
            finish();
            //stop();                    
        }
    };

    mSplashThread.start();