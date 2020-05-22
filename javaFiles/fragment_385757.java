public class TouchingView extends View {

    private final static String TAG="TouchingView";

    private OnTouchListener touchListener;
    private GestureDetector gestureDetector;

    public TouchingView(Context context) {
        super(context);
        touchListener = new TouchListener();
        gestureDetector = new GestureDetector(getContext(), 
                         (GestureDetector.OnGestureListener) touchListener);
        setOnTouchListener(touchListener);
    }

    public TouchingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        touchListener = new TouchListener();
        gestureDetector = new GestureDetector(getContext(), 
                         (GestureDetector.OnGestureListener) touchListener);
        setOnTouchListener(touchListener);
    }

    public TouchingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        touchListener = new TouchListener();
        gestureDetector = new GestureDetector(getContext(), 
                         (GestureDetector.OnGestureListener) touchListener);
        setOnTouchListener(touchListener);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "onTouchEvent: onTouchEvent!!!"); //not logged
        return super.onTouchEvent(event);
    }

    private class TouchListener extends GestureDetector.SimpleOnGestureListener 
                                implements View.OnTouchListener{

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            Log.d(TAG, "onTouch: LISTENER!!!"); //logged upon every touch event. twice upon click (for UP and for DOWN)
            gestureDetector.onTouchEvent(event);
            return true; //preventing the view's onTouchEvent from firing
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) { //you can override onSingleTapConfirmed if you don't want doubleClick to fire it
            Log.d(TAG, "onSingleTapUp: TAP DETECTED"); //logged only upon click
            return true;
        }
    }
}