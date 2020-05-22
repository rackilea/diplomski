@Override
public boolean onTouchEvent(MotionEvent event) {
    if (event.getAction() == MotionEvent.ACTION_DOWN) {
      // Check if click is within bounds of your rect
      if (event.getX() >= mRectStartX && event.getX() <= mRectEndX && event.getY() >= mRectStartY && event.getY() <= mRectEndY) {
        // Clicked within your rect, register further clicks by consuming this click
        return true;
      }
    }

    return super.onTouchEvent(event);
}