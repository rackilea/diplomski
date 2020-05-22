doAnotherLine(0);

private void doAnotherLine(int i){
    //Some stopper method.. for example something like this
    if(i < list.size -1) doCountDown(i);

}

private void doCountDown(final int i){

        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                new CountDownTimer(30000,100) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        //Do some stuff
                    }

                    @Override
                    public void onFinish() {
                        doAnotherLine(i+1);
                    }
                }.start();
            }
        });
}