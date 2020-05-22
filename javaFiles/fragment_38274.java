case MotionEvent.ACTION_MOVE:

        int pointerCount = event.getPointerCount();
        for(int i = 0; i < pointerCount; ++i)
        {
            pointerIndex = i;
            pointerId = event.getPointerId(pointerIndex);
            Log.d("pointer id - move",Integer.toString(pointerId));
            if(pointerId == 0)
            {
                fingerOneDown = 1;
                fingerOneX = event.getX(pointerIndex);
                fingerOneY = event.getY(pointerIndex);
            }
            if(pointerId == 1)
            {
                fingerTwoDown = 1;
                fingerTwoX = event.getX(pointerIndex);
                fingerTwoY = event.getY(pointerIndex);
            }
        }
        break;