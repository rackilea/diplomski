final Handler handler = new Handler();


    image.post( new Runnable() {
        @Override
        public void run() {

            x--;
            handler.postDelayed(this, 100);

        }
    });