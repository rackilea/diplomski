public void run() {

    try{
        Thread.sleep(5000);
    }catch(Exception e){

    }finally{
        Intent in = new Intent(Splash.this,MainActivity.class);
        startActivity(in);
    }


    }
};

timer.start();