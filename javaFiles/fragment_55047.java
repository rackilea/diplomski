public boolean onTouch(View view, MotionEvent event) {
    if(event.getY() < activity.getResources().getDisplayMetrics().heightPixels / 2){
         //top
    }
    else{
         //bottom
    }
    return true; //handle the touch
}