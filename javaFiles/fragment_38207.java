img.setOnTouchListener(new View.OnTouchListener() {                 
    public boolean onTouch(View v, MotionEvent e) {   
        if (e.getAction() == MotionEvent.ACTION_DOWN) {
            ((ImageView) v).setColorFilter(0x44E79B0E, PorterDuff.Mode.SRC_ATOP);
        }
        if ((e.getAction() == MotionEvent.ACTION_UP) || (e.getAction() == MotionEvent.ACTION_CANCEL)) {
            ((ImageView) v).setColorFilter(null);
        }
        return false;
    }
});