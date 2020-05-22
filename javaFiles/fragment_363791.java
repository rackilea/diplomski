private GestureDetectorCompat gestureDetectorCompat;

@Override
protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    gestureDetectorCompat = new GestureDetectorCompat(this, new MyGestureListener());

     //Stuff in onCreate()

}



@Override
public boolean onTouchEvent(MotionEvent event) {
    this.gestureDetectorCompat.onTouchEvent(event);
    return super.onTouchEvent(event);
}
class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float velocityY) {

        //Swipe from the top to the bottom
        if(event2.getY() > event1.getY()){

            getSupportActionBar().show();

            h.postDelayed(new Runnable() {
                @Override
                public void run() {
                    getSupportActionBar().hide();
                }
             }, 6000);

        }
        return true;
    }
}