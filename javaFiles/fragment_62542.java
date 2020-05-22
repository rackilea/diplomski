public boolean onTouchEvent(MotionEvent event) {
      // Do stuff on touch 
      // prevent parent container from processing ACTION_MOVE events
      if(event.getAction() == MotionEvent.ACTION_MOVE) {
        getParent().requestDisallowInterceptTouchEvent(true);
      } else if(event.getAction() == MotionEvent.ACTION_CANCEL) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }

    // Do some more stuff
    return true;
}