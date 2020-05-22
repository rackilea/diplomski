@Override
public boolean onTouchEvent(MotionEvent event)  
 { 
 // get pointer index from the event object int
  pointerIndex = event.getActionIndex();
// get pointer ID 
 int pointerId = event.getPointerId(pointerIndex);
// get masked (not specific to a pointer) action
 int maskedAction = event.getActionMasked();
 switch (maskedAction) 
       { 
        case MotionEvent.ACTION_DOWN: 
          case MotionEvent.ACTION_POINTER_DOWN:
             { 
                // TODO use data break;
             }
          case MotionEvent.ACTION_MOVE:
           {
           // a pointer was moved 
          // TODO use data break;
            } 
           case MotionEvent.ACTION_UP:
           case MotionEvent.ACTION_POINTER_UP:       
           case MotionEvent.ACTION_CANCEL:
           { 
            // TODO use data break; 
           }
      } 
 invalidate(); 
 return true;
 }