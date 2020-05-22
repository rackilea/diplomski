new Handler().postDelayed(new Runnable(){
    @Override
     public void run(){
         runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        TextView tv2 = (TextView) findViewById(R.id.tvSecond);
                        tv2.setText("I set this text after waiting for 2 seconds");

                    }
                });

      }
 },2000);