private static final float MOVE_PRECISION = 5; // You may want to tune this parameter
private float lastY;

// ...

@Override
public boolean onTouchEvent(MotionEvent event) {
    if (!isEnabled()) {
        return false;
    }

    switch (event.getAction()) {
        case MotionEvent.ACTION_DOWN:
            lastY = event.getY();

            if (myListener != null)
                myListener.onStartTrackingTouch(this);
            break;
        case MotionEvent.ACTION_MOVE:
            if (calculateDistanceY(event) > MOVE_PRECISION) {
                setProgress(getMax() - (int) (getMax() * event.getY() / getHeight()));
                onSizeChanged(getWidth(), getHeight(), 0, 0);
                myListener.onProgressChanged(this, getMax() - (int) (getMax() * event.getY() / getHeight()), true);

                lastY = event.getY();
            }
            break;
        case MotionEvent.ACTION_UP:
            myListener.onStopTrackingTouch(this);
            break;

        case MotionEvent.ACTION_CANCEL:
            break;
    }
    return true;
}

private float calculateDistanceY (MotionEvent event) {
    return Math.abs(event.getY() - lastY);
}