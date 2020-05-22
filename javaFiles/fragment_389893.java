@Override
        protected void onResume() {
            super.onResume();
            if (mHandler != null) {
                if(mHandler!=null){
                    mHandler.postDelayed(mRunnable, 1000);//time in miliseconds
/
                }

            }

        }

    @Override
    protected void onPause() {
        super.onPause();
        if (mHandler != null) {
            if(mHandler!=null){
                mHandler.removeCallbacks(mRunnable);//time in miliseconds
            }

        }

    }