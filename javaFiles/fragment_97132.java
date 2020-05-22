@Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            // Log.i("Click", "ACTION_DOWN");
            touch = true;
            this.invalidate();

        } else if (ev.getAction() == MotionEvent.ACTION_UP) {
            touch = false;
            this.invalidate();
            // KEY LINE
            performClick();
        }
        return true;


    }