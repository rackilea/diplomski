private boolean mFlag = true;


 @Override
 public void afterTextChanged(final Editable s) {

    // HERE IS WHERE I WILL CALL MY FUNCTION (Prints show my issue)    

    Log.w(TAG, "TEXT CHANGE " + s);

    final Runnable mRunnable = new Runnable() {
        @Override
        public void run(){
            final Editable x = s;
            Log.w(TAG, "DELAY TEXT " + x.toString());
        }
    }

    if(mFlag){
        mHandler.postDelayed(r, 1000);    
        mFlag = false;
    }

}