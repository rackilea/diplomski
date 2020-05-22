@Override
  public boolean onTouchEvent(MotionEvent ev) {
    if (isEnableScrolling()) {
        return super.onTouchEvent(ev);
    } else {
       return false;
    }
  }