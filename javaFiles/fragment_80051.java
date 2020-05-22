timer.schedule(new TimerTask(){

        @Override
        public void run() {
            // TODO Auto-generated method stub
            runOnUiThread(new Runnable() {

            @Override
            public void run() {
                mSwitcher.setImageResource(mImageIds[position]);
            }
        });
            position++;
        }

    }, delay, pause);