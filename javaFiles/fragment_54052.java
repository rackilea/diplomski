viewPager.setOnTouchListener(new OnTouchListener() {
    private int CLICK_ACTION_THRESHOLD = 200;
    private float startX;
    private float startY;

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
        case MotionEvent.ACTION_DOWN:
            startX = event.getX();
            startY = event.getY();
            break;
        case MotionEvent.ACTION_UP: 
            float endX = event.getX();
            float endY = event.getY();
            if (isAClick(startX, endX, startY, endY)) { 
                launchFullPhotoActivity(imageUrls);// WE HAVE A CLICK!!
            }
            break;
        }
        v.getParent().requestDisallowInterceptTouchEvent(true); //specific to my project
        return false; //specific to my project
    }

    private boolean isAClick(float startX, float endX, float startY, float endY) {
        float differenceX = Math.abs(startX - endX);
        float differenceY = Math.abs(startY - endY);
        return !(differenceX > CLICK_ACTION_THRESHOLD/* =5 */ || differenceY > CLICK_ACTION_THRESHOLD);
    } 
}