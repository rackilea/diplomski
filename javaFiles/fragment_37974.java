public boolean onTouch(View v, MotionEvent event) {
   int x = (int)event.getX();
   int y = (int)event.getY();
   if(isInsideCircle(x, y)){
      //Do your things here
   }
   return true;
}

private boolean isInsideCircle(int x, int y){
  if (((x - center_x)^2 + (y - center_y)^2) < radius^2)
    return true;
  return false;    
}