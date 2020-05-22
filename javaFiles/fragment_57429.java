@Override
public void onUserInteraction() {
    isStarted = true;
    Handler handler = new Handler();
    handler.postDelayed(new Runnable () {
        public void run() {
          if(isStarted){
            finish();
            }
         }
    }, 5000);