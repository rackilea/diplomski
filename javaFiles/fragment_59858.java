gestureListener = new View.OnTouchListener(){
        public boolean onTouch(View v, MotionEvent event){
            return gestureDetector.onTouchEvent(event);
        }
    };

lv.setOnTouchListener(gestureListener);