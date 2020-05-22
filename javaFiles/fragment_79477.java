@Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //Start of touch events 
                stage++;
                System.out.println(stage);
                handleTouches();
                System.out.println(onTouchEvent(event));
                //return onTouchEvent(event);
                return true;
            case MotionEvent.ACTION_UP:
                // End of touch events
                return true;
            case MotionEvent.ACTION_MOVE:
                // Moved touch events
                return true;
        }
        return true;
    }