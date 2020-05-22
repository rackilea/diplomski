private OnTouchListener image_Listener = new OnTouchListener(){
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_UP) {
            float screenX = event.getX();
            float screenY = event.getY();
            float viewX = screenX - v.getLeft();
            float viewY = screenY - v.getTop();
            return true;
        }
        return false;
    }
};