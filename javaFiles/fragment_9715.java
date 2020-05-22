long startTime;
public boolean onTouchEvent(MotionEvent event) {

    if (event.getAction() == MotionEvent.ACTION_DOWN) 
        startTime = System.nanoTime();    

    else if (event.getAction() == MotionEvent.ACTION_UP) {
        long elapseTime = System.nanoTime() - startTime;
        //do whatever u want with elapseTime now, its in nanoseconds
    }
}