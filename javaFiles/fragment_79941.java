public void currentProgress(float p, float time) {
    if(time == yourTime){
        a.bringToFront();
        a.invalidate();
        b.invalidate();
        a.requestLayout();
        b.requestLayout();
    }
}