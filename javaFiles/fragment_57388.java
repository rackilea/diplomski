boolean surfaceTouchEvent(MotionEvent event) {
  pointNum=event.getPointerCount();
  if(pointNum >= 2) {
    // your code here
  } else {
    return false;
  }
}