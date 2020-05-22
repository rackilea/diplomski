Handler handler = new Handler();
 final Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            setTimeElapsed(hoursEditText);
            handler.postDelayed(this, 100);
        }
    });