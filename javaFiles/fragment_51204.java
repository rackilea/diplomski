((Activity)getContext()).runOnUiThread(new Runnable() {

        @Override
        public void run() {
              Intent gameOver = new Intent(getContext(),GameOver.class);
              gameOver.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
              getContext().startActivity(gameOver);
              ((Activity)getContext()).finish();
        }
 });