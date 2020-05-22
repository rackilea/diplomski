@Override
public boolean onInterceptTouchEvent(MotionEvent ev) {
    if (touchesAllowed()) {
        return super.onInterceptTouchEvent(ev);
    } else {
        if (MotionEventCompat.getActionMasked(ev) == MotionEvent.ACTION_MOVE) {
            // ignore move action
        } else {
            if (super.onInterceptTouchEvent(ev)) {
                super.onTouchEvent(ev);
            }
        }
        return false;
    }
}

@Override
public boolean onTouchEvent(MotionEvent ev) {
    if (touchesAllowed()) {
        return super.onTouchEvent(ev);
    } else {
        return MotionEventCompat.getActionMasked(ev) != MotionEvent.ACTION_MOVE && super.onTouchEvent(ev);
    }
}