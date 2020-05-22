@Override
public boolean onTouchEvent(MotionEvent event) 
{
    int x=(int)event.getX();
    int y=(int)event.getY();
    if (drawable.getBounds().contains(x,y)  &&
        event.getAction()==MotionEvent.ACTION_DOWN) {
        System.out.println("Button Pushed");
        return true;
    }
    return false;
}