new Handler(mContext.getMainLooper()).post(new Runnable() {
        @Override
        public void run() {
            try {
                mWorkoutsModel.onStart();
                mLock.await();
                mWorkoutsModel.onStop();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });