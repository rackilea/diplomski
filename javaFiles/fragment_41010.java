mGestureDetector = new GestureDetector(this, this);
mMapView.setOnTouchListener(mOnTouchListener);


public OnTouchListener mOnTouchListener = new OnTouchListener() {
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (mGestureDetector.onTouchEvent(event))
            return true;
        else
            return false;
    }
};

@Override
public boolean onDoubleTap(MotionEvent arg0) {
    Log.v(TAG, "onDoubleTap");
    return true;
}