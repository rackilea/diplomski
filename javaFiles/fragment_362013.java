public boolean onTouchEvent (MotionEvent event){
        final int action = event.getAction();
        final int x = (int) event.getX();
        final int y = (int) event.getY();
        switch (action & MotionEventCompat.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                if (!region.contains(x, y)) {
                    mShadowView.setVisibility(INVISIBLE);
                    mCloseView.setVisibility(GONE);
                    mPushView.setVisibility(GONE);
                }
                break;
        }
        return true;
    }