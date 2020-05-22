view.setOnTouchListener(new OnTouchListener() {

    private long startClickTime;

    @Override
    public boolean onTouch(View view, MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN) {

            startClickTime = System.currentTimeMillis();

        } else if (event.getAction() == MotionEvent.ACTION_UP) {

            if (System.currentTimeMillis() - startClickTime < ViewConfiguration.getTapTimeout()) {

                // Touch was a simple tap. Do whatever.

            } else {

                // Touch was a not a simple tap.

            }

        }

        return true;
    }

});