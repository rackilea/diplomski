public class MyViewPager extends ViewPager {

  private GestureDetector gestureDetector;

  public MyViewPager(Context context) {
    super(context);
  }

  public MyViewPager(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  public boolean onTouchEvent(MotionEvent e) {
    return super.onTouchEvent(e) && gestureDetector.onTouchEvent(e);
  }
}