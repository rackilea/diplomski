@Override
public boolean onInterceptTouchEvent(MotionEvent ev) {
    if(checkCoordinateCross(ev, YOUR_TARGET_VIEW_ID)) {
        return false;
    }
    return true;
}
private boolean checkCoordinateCross(MotionEvent ev, int resId) {
    View target = findViewById(resId);
    if(target == null) {
        return false;
    }
    if(ev.getX() > target.getX() && ev.getX() < target.getX() + target.getWidth() && ev.getY() > target.getY() && ev.getY() < target.getY() + target.getHeight()) {
        return true;
    }
    return false;
}