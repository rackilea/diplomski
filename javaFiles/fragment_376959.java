private int DELAY = 1500; // Delay time in milliseconds

new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
              computersTurn();
           }
         }, DELAY);