public class MyActivity extends Activity {
    private GestureDetector detector;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.swipe_tester);
        detector = new GestureDetector(this, new SwipeListener());
    }     

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        boolean consumed = detector.onTouchEvent(e);
        if (consumed) {return true;} 
        return super.onTouchEvent(e);
    }

    public class SwipeListener extends GestureDetector.SimpleOnGestureListener {
         public static final int MIN_SWIPE_DISTANCE = 40; 

        /**
         * Whether or not you use {@link GestureDetector.SimpleOnGestureListener},
         * you must always implement an {@link OnGestureListener#onDown(MotionEvent)}
         * method that returns {@code true}. This step is necessary because all gestures
         * begin with an {@code onDown()} message.
         *
         * For more details see
         * https://developer.android.com/training/custom-views/making-interactive.html#inputgesture
         */
        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        /**
         * @return {@code true} if event is consumed by this method.
         */
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
           float xDiff = e1.getX() - e2.getX();
           float yDiff = e1.getY() - e2.getY();
           return resolveSwipe(xDiff, yDiff);
        }

        /**
         * @return {@code true} if swipe movement was detected.
         */
        private boolean resolveSwipe(float xDist, float yDist) {
            float yDistAbs = Math.abs(yDist);
            float xDistAbs = Math.abs(xDist);

            SwipeDirection swipeDirection;

            // movement along y axis is dominant = resolve as vertical movement
            if (yDistAbs > xDistAbs) {
                if (yDistAbs < MIN_SWIPE_DISTANCE) {return false;}
                swipeDirection = (yDist > 0) ? SwipeDirection.DOWN: SwipeDirection.UP;

            } else {
                if (xDistAbs < MIN_SWIPE_DISTANCE) {return false;}
                swipeDirection = (xDist > 0) ? SwipeDirection.RIGHT: SwipeDirection.LEFT;
            }

            onSwipeEvent(swipeDirection);
            return true;
        }

        private void onSwipeEvent(SwipeDirection swipeDirection) {
            if (swipeDirection == SwipeDirection.UP) {
                Log.d("[MATONI]", "[CLASS]: " + SwipeListener.class.getSimpleName() + ", [MESSAGE]: UP");
                Toast.makeText(TestActivity.this, "UP",  Toast.LENGTH_SHORT).show();
                return;
            }
            if (swipeDirection == SwipeDirection.DOWN) {
                Log.d("[MATONI]", "[CLASS]: " + SwipeListener.class.getSimpleName() + ", [MESSAGE]: DOWN");
                Toast.makeText(TestActivity.this, "DOWN",  Toast.LENGTH_SHORT).show();
                return;
            }
            if (swipeDirection == SwipeDirection.LEFT) {
                Log.d("[MATONI]", "[CLASS]: " + SwipeListener.class.getSimpleName() + ", [MESSAGE]: LEFT");
                Toast.makeText(TestActivity.this, "LEFT",  Toast.LENGTH_SHORT).show();
                return;
            }
            if (swipeDirection == SwipeDirection.RIGHT) {
                Log.d("[MATONI]", "[CLASS]: " + SwipeListener.class.getSimpleName() + ", [MESSAGE]: RIGHT");
                Toast.makeText(TestActivity.this, "RIGHT",  Toast.LENGTH_SHORT).show();
                return;
            }
            // or alternatively
            //switch (swipeDirection) {
            //    case UP: Toast.makeText(TestActivity.this, "UP", Toast.LENGTH_SHORT).show();
            //        break;
            //    case DOWN: Toast.makeText(TestActivity.this, "DOWN", Toast.LENGTH_SHORT).show();
            //        break;
            //    case LEFT: Toast.makeText(TestActivity.this, "LEFT", Toast.LENGTH_SHORT).show();
            //        break;
            //    case RIGHT: Toast.makeText(TestActivity.this, "RIGHT", Toast.LENGTH_SHORT).show();
            //        break;
            //    default: new AssertionError("Should not happen");
            //}
        }
    }

    public enum SwipeDirection {
        UP, DOWN, LEFT, RIGHT
    }
}