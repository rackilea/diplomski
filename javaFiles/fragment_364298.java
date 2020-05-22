timer = new Timer();

public boolean onTouchEvent(MotionEvent event) 
{
    switch(event.getAction()) 
    {
        case MotionEvent.ACTION_DOWN:
             break;

        case MotionEvent.ACTION_MOVE:
             timer.cancel();
             timer = null;
             timer = new Timer();
             timer.schedule(new TimerTask() 
             {                  
                @Override
                public void run() {
                    // do your long press task here
                }
             }, 3000);
             break;

        case MotionEvent.ACTION_UP:
             timer.cancel();
             timer = null;
             break;
    }
    return super.onTouchEvent(event);
}