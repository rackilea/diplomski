@Override
        public boolean onTouch(View arg0, MotionEvent arg1) {
        if(arg1.getAction() == MotionEvent.ACTION_DOWN) {
                // This is what happens on the click down... 
            } else if(arg1.getAction() == MotionEvent.ACTION_UP) {
                // this is what happens on the click release
                return true;
            }
            return false;
        }});