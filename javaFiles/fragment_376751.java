CountDownTimer mCountDownTimer;

final ProgressBar mProgressBar=(ProgressBar)findViewById(R.id.progressBartime);
mProgressBar.setProgress(i);
mCountDownTimer=new CountDownTimer(3000,1000) {
    int i = 0;

    @Override
    public void onTick(long millisUntilFinished) {
        Log.v("Log_tag", "Tick of Progress"+ i+ millisUntilFinished); //i needs to be declared as final
        i++; 
        mProgressBar.setProgress(i); //mProgressBar needs to be declared as final

    }


    @Override
    public void onFinish() {
        //Do what you want
        i++;  
        mProgressBar.setProgress(i); //mProgressBar needs to be declared as final
    }
};