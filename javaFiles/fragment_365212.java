@Override
public boolean onTouchEvent(MotionEvent event) {
    if (isInGrayArea(event.getX(), event.getY())) {
       return super.onTouchEvent(event);
    }
    return false;
}