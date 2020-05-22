public class MyGestureListener extends SimpleOnGestureListener {

  private final Activity activity;

  public MyGestureListener(Activity activity) {
    super();
    this.activity = activity;
  }

  @Override
  public boolean onDoubleTap(MotionEvent e) {
    //...
  }

  @Override
  public boolean onSingleTapConfirmed(MotionEvent e) {
    //...
  }

//... etc...

}