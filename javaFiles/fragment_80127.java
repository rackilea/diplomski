public void onTick(long millisUntilFinished) {

            float fraction = millisUntilFinished / (float) totalMsecs;

                        // myActivity is passed in the constructor
            mMillisUntilFinished = millisUntilFinished;

            // progress bar is based on scale of 1 to 100;
            mActivity.progressBar.setProgress((int) (fraction * 100));

        }

        public void onFinish() {
                mMillisUntilFinished = 0;
            handleTimeOut();
        }