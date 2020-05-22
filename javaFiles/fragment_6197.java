yourView.setOnTouchListener(new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN){
                int x = event.getX();
                int y = event.getY();
                if(x > rectLeftX && x < rectRightX && y > rectBottomY && y < rectTopY){
                    /* Trigger your action here */
                }
            }
            return true;
        }
    });