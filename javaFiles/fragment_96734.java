@Override
    public boolean onTouchEvent(MotionEvent me){
        if(me.getAction() == MotionEvent.ACTION_DOWN) {
            //float x = me.getX();
            //float y = me.getY();
            performClick();
            //enter your code here
        }
        return false;
    }