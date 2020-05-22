@Override
public boolean onTouchEvent (MotionEvent event) {

  if (event.getAction() == MotionEvent.ACTION_DOWN) {

    start_x = event.getX();
    start_y = event.getY();     

  } else if (event.getAction() == MotionEvent.ACTION_MOVE) {

    //create the line from start_x and start_y to the current location
    //don't forget to invalidate the View otherwise your line won't get redrawn

  } else if (event.getAction() == MotionEvent.ACTION_UP) {

    //might not need anything here

  }
  return true;
}