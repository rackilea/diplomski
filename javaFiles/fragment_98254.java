@Override
public boolean onTouchEvent(MotionEvent event) {
    int eventaction = event.getAction();

    switch (eventaction) {
    case MotionEvent.ACTION_DOWN:

        titleView.setVisibility(View.INVISIBLE);
        startNotifView.setVisibility(View.INVISIBLE);
        break;
    }
    return true;
}