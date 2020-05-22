@Override
public boolean onTouchEvent(MotionEvent event) {

    switch (event.getAction() & MotionEvent.ACTION_MASK) {
        case MotionEvent.ACTION_DOWN:
           //touch start
           break;
        case MotionEvent.ACTION_UP:
           //touch finish
           break;
    }
}