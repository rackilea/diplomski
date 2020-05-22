@Override
public boolean onTouchEvent (MotionEvent event){
    if(event.getActionMasked() == MotionEvent.DOWN){
        startX = event.getX();
        startY = event.getY();
        return true;
    }else if(event.getActionMasked() == MotionEvent.MOVE){
        ammountX = event.getX() - startX;
        ammountY = event.getY() - startY;
        return true;
    }
    return super.onTouchEvent(event);
}