boolean flag;
public boolean onTouch(View view, MotionEvent event){
    int action = event.getAction() & MotionEvent.ACTION_MASK;
        if(action == MotionEvent.ACTION_DOWN){
            //do something on a down press
            flag = true;
            return true;
        }
        if(action == MotionEvent.ACTION_UP && flag == true){
            //do something if we move finger away from screen we 
            //didn't move the view first

            return true;
        }
        if(action == MotionEvent.ACTION_UP && flag == false){
            //do something if we move finger away from screen and we moved 
            //the view before we moved the finger away from screen
        }
        if(action == MotionEvent.ACTION_MOVE){
            //do something when moving the view
            flag = false;
        }