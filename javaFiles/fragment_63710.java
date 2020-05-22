public class MarqueeTextView extends TextView implements OnGestureListener {

    private GestureDetector gestureDetector;
    private Marquee marquee;
    private Scroller scroller;

    // constructor
    public MarqueeTextView(Context context, AttributeSet attrs) {
        this.marquee = new Marquee(this);
        this.scroller = new Scroller(context);
        this.setScroller(scroller);
        gestureDetector = new GestureDetector(getContext(), this);
        // when enabled, longpress disables further movement tracking
        gestureDetector.setIsLongpressEnabled(false);
    }

    public boolean onScroll(MotionEvent e1, MotionEvent e2,
                            float distanceX, float distanceY) {
        marquee.addToScroll(distanceX);
        return false;
    }

    // onDraw
    protected void onDraw(Canvas canvas) {
        scroller.setFinalX((int) marquee.mScroll);
        super.onDraw(canvas);
    }

    // Marquee handler
    private static final class Marquee extends Handler {
        // mostly the same as original
        // ...

        float mScroll;

        public void addToScroll(float amount) {
            mScroll += amount;
            // detect if needs to start over
        }
    }
}