public boolean onTouchEvent(View v, MotionEvent event) {
        Button zero = (Button) v;

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            zero.setBackgroundResource(R.drawable.arrow_leftpressed);
            return true;
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            zero.setBackgroundResource(R.drawable.arrow_left);
            return true;
        }

        return false;
    }