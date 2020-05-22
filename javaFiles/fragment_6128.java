@Override
public boolean onAreaTouched(final TouchEvent touchEvent, ITouchArea touchArea, float touchAreaLocalX, float touchAreaLocalY) {
    switch(touchEvent.getAction()){
                case TouchEvent.ACTION_MOVE:{
                    // do stuff when finger moves
                    return true; // don't forget to break, or return true directly if the event was handled
                }
                case TouchEvent.ACTION_DOWN:{
                    // do stuff, the first time the finger touches the display
                    return true; 
                }
                case TouchEvent.ACTION_UP:{
                    // do stuff when the finger goes up again and ends the touch event (your case)
                    return true; 
                }
                case TouchEvent.ACTION_CANCEL:{
                    // If the event is somehow canceled - e.g. the finger leaves the display
                    return true; 
                }
                default:{
                    // none of the above
                    return false;
                }
    }
}