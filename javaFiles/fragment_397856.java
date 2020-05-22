public class HSwipeDetector extends SimpleOnGestureListener {
    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_MAX_OFF_PATH = 250;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;

    @Override
    public boolean onFling(final MotionEvent e1, final MotionEvent e2, final float velocityX, final float velocityY) {
        if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH) {  return false;  }

        /* positive value means right to left direction */
        final float distance = e1.getX() - e2.getX();
        final boolean enoughSpeed = Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY;
        if(distance > SWIPE_MIN_DISTANCE && enoughSpeed) {
            // right to left swipe
            onSwipeLeft();
            return true;
        }  else if (distance < -SWIPE_MIN_DISTANCE && enoughSpeed) {
            // left to right swipe
            onSwipeRight();
            return true;
        } else {
            // oooou, it didn't qualify; do nothing
            return false;
        }
    }

    protected void onSwipeLeft() { 
        // do your stuff here
    }

    protected void onSwipeRight() {   
        // do your stuff here
    }
}