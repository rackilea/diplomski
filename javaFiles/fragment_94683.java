public class MySlideListener implements View.OnTouchListener {

    private View view;
    private ListView listView;
    private GestureDetector gestureDetector;

    public MySlideListener(ListView lv) {
        listView = lv;
        gestureDetector = new GestureDetector(lv.getContext(), myGestureListener);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        view = v;
        gestureDetector.onTouchEvent(event);
        return true;
    }

    private SimpleOnGestureListener myGestureListener = new SimpleOnGestureListener() {

    private int origLeft, origRight;

    public boolean onDown(MotionEvent e) {
        MarginLayoutParams lp = (MarginLayoutParams) view.getLayoutParams();
        origLeft = lp.leftMargin;
        origRight = lp.rightMargin;
        return true;
    };

    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        listView.requestDisallowInterceptTouchEvent(true);
        MarginLayoutParams lp = (MarginLayoutParams) view.getLayoutParams();
        lp.leftMargin = (int) (origLeft + (e2.getRawX() - e1.getRawX()));
        lp.rightMargin = (int) (origRight - (e2.getRawX() - e1.getRawX()));
        view.requestLayout();
        return true;
    };
    };
}