@Override
public boolean onTouchEvent(MotionEvent event) {
    int x = (int) event.getX();
    int y = (int) event.getY();
    switch (event.getAction()) {
        case MotionEvent.ACTION_DOWN:
            // do something;
            break;
        case MotionEvent.ACTION_MOVE:
            // do something;
            break;
        case MotionEvent.ACTION_UP:
            // do something;
            break;
        default:
            return super.onTouchEvent(event);
    }
    return false;
}