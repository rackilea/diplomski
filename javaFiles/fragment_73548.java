rl.setOnTouchListener(new OnTouchListener() {
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {  
        if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
            if (isTouchInView(view, motionEvent)) {
                //lifted finger while touch was in view
                view.performClick();
            }

            view.setBackgroundColor(Color.WHITE);
            return true;
        }

        if (motionEvent.getAction() == MotionEvent.ACTION_MOVE) {
            //finger still down and left view
            if (!isTouchInView(view, motionEvent)) {
                view.setBackgroundColor(Color.WHITE);
            }
        }

        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            //pressed down on view
            view.setBackgroundColor(Color.BLACK);
            return true;
        }

        if (motionEvent.getAction() == MotionEvent.ACTION_CANCEL) {
            //a cancel event was received, finger up out of view
            view.setBackgroundColor(Color.WHITE);
            return true;
        }
        return false;
    }

    private boolean isTouchInView(View view, MotionEvent event) {
        Rect hitBox = new Rect();
        view.getGlobalVisibleRect(hitBox);
        return hitBox.contains((int) event.getRawX(), (int) event.getRawY());
    }