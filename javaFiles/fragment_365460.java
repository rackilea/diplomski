@Override
public boolean onTouchEvent(MotionEvent event)
{
    int num = event.getPointerCount();
    for (int a = 0; a < num; a++) {
        int x = (int) event.getX(event.getPointerId(a));
        int y = (int) event.getY(event.getPointerId(a));
        if(y > screenY/2)  playerPoint1.set(x, y);
        if(y < screenY/2)  playerPoint2.set(x, y);
    }
    return true;
}