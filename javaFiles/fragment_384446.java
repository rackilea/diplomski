private int a = 0;
private Handler handler = new Handler();
private TextView textView2;

public void loop() {
     handler.post(new Runnable() {
         @Override
         public void run() {
             updateText();
             a = a++ % 10;
             if (a < 10) {
                 handler.postDelayed(this, 1000);
             }
         }
     });
}

public void updateText() {
    textView2.setText("" + a);
}