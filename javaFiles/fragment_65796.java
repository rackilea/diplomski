final Handler mHandler = new Handler();
int ms=2000;

final Runnable mUpdateTimeTask = new Runnable() {
    public void run() {
        //Do random logic

        ms -= 20;
        if( ms > 0 ) // stop when delay is less than 0.
            mHandler.postDelayed( this, ms );
    }

};


// run this in a method.
mHandler.postDelayed(mUpdateTimeTask, ms); // post the first