@Override
public boolean dispatchTouchEvent(MotionEvent ev) {
    try {
        return super.dispatchTouchEvent(ev);
    } catch (Exception e) {
        return false;
    }
}

@Override
public boolean onTouchEvent(MotionEvent ev) {
    try {
        return super.onTouchEvent(ev);
    } catch (Exception e) {
        return false;
    }
}