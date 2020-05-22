@Override 
public boolean onTouchEvent(MotionEvent event) {

    switch (event.getAction()) {
        case MotionEvent.ACTION_DOWN: // Fall through
        case MotionEvent.ACTION_MOVE: // Fall through
        case MotionEvent.ACTION_UP: // Fall through
            rows = (int)event.getX();
            cols = (int)event.getY();
            invalidate();
            return true;
    }
    return false;
}