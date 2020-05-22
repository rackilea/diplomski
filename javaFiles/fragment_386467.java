RelativeLayout rLayout= (RelativeLayout) findViewById(R.id.layout);

rLayout.setOnTouchListener(new View.OnTouchListener() {
    public boolean onTouch(View v, MotionEvent event) {
        text1.setText("Debug3");
        return gestureDetector.onTouchEvent(event);
    }
});