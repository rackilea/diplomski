public class MyCustomSwipeRefreshLayout extends SwipeRefreshLayout {

    private static final String TAG = "OneTouchRefreshFreeSwip";
    private static final float DEFAULT_SCALE_TRIGGER_DISTANCE = 48;// in dp
    private int mTouchSlop;
    private float mPrevX;

    private ScaleGestureDetector mScaleGestureDetector;
    private ScaleListener mScaleListener;

    private float mScaleTriggerDistance;
    private float mInitialDistance;

    public MyCustomSwipeRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public void setScaleListener(Context context, ScaleListener scaleListener) {
        this.mScaleListener = scaleListener;
        mScaleGestureDetector = new ScaleGestureDetector(context, new MyOnScaleGestureListener());
        mScaleTriggerDistance = Util.dp2px(DEFAULT_SCALE_TRIGGER_DISTANCE, context);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (mScaleGestureDetector != null) {
            mScaleGestureDetector.onTouchEvent(event);
        }

        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_POINTER_DOWN:
                setEnabled(false);
                if (mScaleListener != null) {
                    mScaleListener.onTwoFingersStart();
                }
                break;
            case MotionEvent.ACTION_POINTER_UP:
                if (mScaleListener != null) {
                    mScaleListener.onTwoFingersEnd();
                }
                mPrevX = MotionEvent.obtain(event).getX();
                setEnabled(true);
                return true;
            case MotionEvent.ACTION_DOWN:
                mPrevX = MotionEvent.obtain(event).getX();
                break;

            case MotionEvent.ACTION_MOVE:
                final float eventX = event.getX();
                float xDiff = Math.abs(eventX - mPrevX);

                if (xDiff > mTouchSlop) {
                    return false;
                }
        }

        return super.onInterceptTouchEvent(event);
    }

    private boolean gestureTolerance(@NonNull ScaleGestureDetector detector) {
        final float currentDistance = detector.getCurrentSpan();
        final float distanceDelta = Math.abs(mInitialDistance - currentDistance);
        return distanceDelta > mScaleTriggerDistance;
    }

    class MyOnScaleGestureListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {

        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            if (gestureTolerance(detector)) {
                if (mScaleListener != null) {
                    float scaleFactor = detector.getScaleFactor();
                    if (scaleFactor > 1F) {
                        mScaleListener.onScaleUp(scaleFactor);
                        mInitialDistance = detector.getCurrentSpan();
                    } else if (scaleFactor < 1F) {
                        mScaleListener.onScaleDown(scaleFactor);
                        mInitialDistance = detector.getCurrentSpan();
                    }
                }
            }
            return true;
        }

        @Override
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            mInitialDistance = detector.getCurrentSpan();
            return true;
        }

        @Override
        public void onScaleEnd(ScaleGestureDetector detector) {
        }
    }

    public interface ScaleListener {
        void onTwoFingersStart();

        void onTwoFingersEnd();

        void onScaleUp(float scaleFactor);

        void onScaleDown(float scaleFactor);
    }
}