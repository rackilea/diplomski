@Override
protected void onCreate(Bundle savedInstanceState) {

    // Your codes ...

    ImageView imageViewEmpty = (ImageView) findViewById(R.id.empty);
    imageViewEmpty.setOnTouchListener(new View.OnTouchListener() {
         @Override
         public boolean onTouch(View v, MotionEvent event) {
              return true; // Consume the event!
         }
    });
}