@Override
  public boolean onTouchEvent(MotionEvent ev) {
    if (isEnableScrolling()) {
        return super.onInterceptTouchEvent(ev);
    } else {
       return false;
    }
  }