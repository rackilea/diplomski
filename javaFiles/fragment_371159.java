@Override
    public boolean onTouchEvent(MotionEvent e) {
       // find if RecyclerView item exists with given coordinates
        View childView = findChildViewUnder(e.getX(), e.getY());
        //if exists - perform click
        if (childView != null) {
            childView.performClick();
        }
        return false;
    }