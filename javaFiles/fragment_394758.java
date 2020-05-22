sourceView.setOnTouchListener(new View.OnTouchListener() {
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        MotionEvent motionEvent = MotionEvent.obtain(event);

        //these 3 lines is for bug when target and source has different on screen positions
        sourceView.getLocationOnScreen(posTemp1);
        targetView.getLocationOnScreen(posTemp2);
        motionEvent.offsetLocation(posTemp1[0]-posTemp2[0], posTemp1[1]-posTemp2[1]);

        targetView.dispatchTouchEvent(motionEvent);
        return false; //true if we want sourceView to not handle it
    }
});