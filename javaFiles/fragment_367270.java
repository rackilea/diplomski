Thread thread=new Thread(){
    @Override
    public void run() {
        float i;
        try {

            for ( i = 0; i <= 100; i++) {
                runOnUiThread(new Runnable() {
                    public void run() {
                        Speedometer1.onSpeedChanged(Speedometer1.getCurrentSpeed(i) + 8);
                        Speedometer2.onSpeedChanged(Speedometer2.getCurrentSpeed(i) + 8);
                        Speedometer3.onSpeedChanged(Speedometer3.getCurrentSpeed(i) + 8);
                        Speedometer4.onSpeedChanged(Speedometer4.getCurrentSpeed(i) + 8);
                        Speedometer5.onSpeedChanged(Speedometer5.getCurrentSpeed(i) + 8);
                        Speedometer6.onSpeedChanged(Speedometer6.getCurrentSpeed(i) + 8)

                    }

                });


                sleep(500);
            }
        }
        catch (InterruptedException e)
        {e.printStackTrace();}
    }
};thread.start();