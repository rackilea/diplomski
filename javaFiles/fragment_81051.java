view.setOnTouchListener(new View.OnTouchListener() {
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN){
                int x = (int) event.getX();
                int y = (int) event.getY();
            }
            return true;
        }
    });