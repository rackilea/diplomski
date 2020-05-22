private GestureDetector gestureDetector;
View.OnTouchListener gestureListener;

gestureDetector = new GestureDetector(new MyGestureDetector());
    gestureListener = new View.OnTouchListener() {
        public boolean onTouch(View v, MotionEvent event) {
            if (gestureDetector.onTouchEvent(event)) {
                return true;
            }
            return false;
        }
    };