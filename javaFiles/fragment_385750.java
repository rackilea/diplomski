touchListener = new View.OnTouchListener() {    
    public boolean onTouch(View view, MotionEvent motionEvent) {    
        final int action = motionEvent.getAction();       
        final int fingersCount = motionEvent.getPointerCount();        
        if ((action == MotionEvent.ACTION_POINTER_UP) && (fingersCount == 2)) {             
            onTwoFingersTap();       
            return true;         
        } 
     return gestureDetector.onTouchEvent(motionEvent);     
    } 
 };