@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    final Handler handler = new Handler();

    final Runnable runnable = new Runnable() {
        @Override
        public void run() {
            sendMessage("0");
        }
    };


    Button btn = (Button) findViewById(R.id.btn);

    btn.setOnTouchListener(new OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                sendMessage("1");
                handler.postDelayed(runnable, 5000);
                break;
            case MotionEvent.ACTION_UP:
                handler.removeCallbacks(runnable);
                break;
            }
            return true;
        }
    });

}

private void sendMessage(String message) {
    Log.i("Message", message);
}