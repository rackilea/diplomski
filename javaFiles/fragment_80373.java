Handler viewHandler = new Handler();
Runnable updateView = new Runnable() {
        @Override
        public void run() {

                mEmulatorView.invalidate();
                viewHandler.postDelayed(updateView, 1000);


        }
    };