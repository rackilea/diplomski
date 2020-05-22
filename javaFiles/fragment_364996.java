@Override
public boolean  onTouchEvent(MotionEvent event){
if (I don't need this touch)
{
   return false;
}
    switch(event.getAction()){
    case MotionEvent.ACTION_UP:
        //Game Over?
        if(quizWorld.swapQuestion()==false){
            viewFlipper.setDisplayedChild(1);
        }
        break;
    }
    return true;    
}