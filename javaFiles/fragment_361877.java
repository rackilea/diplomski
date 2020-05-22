@Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch(action) {
            case MotionEvent.ACTION_DOWN:
                Log.i(AGL, "InterceptAction = DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i(AGL, "InterceptAction = MOVE");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.i(AGL, "InterceptAction = CANCEL");
                return false;
        }
        return true;  //returning true tells your main Activity that you want the custom GridView to handle this TouchEvent; It will then send the TouchEvent to your GridView's onTouchEvent() method for handling.
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch(action) {
            case MotionEvent.ACTION_MOVE:
                int xCoord = (int) event.getX();
                int yCoord = (int) event.getY();
                Log.i(AGL, "MOVE EVENT;" + "\n" +  "Touch X = " + Integer.toString(xCoord) + "\n" +
                "Touch Y = " + Integer.toString(yCoord));
                for(int i = 0; i < this.getChildCount(); i++) {
                    ImageView suspect = (ImageView) this.getChildAt(i);
                    if(suspect.getBounds().contains(xCoord, yCoord)) {
                        suspect.CHANGE_YOUR_IMAGE_HERE();
                        suspect.invalidate();
                    }
                }
                break;
        }

        return true;
    }