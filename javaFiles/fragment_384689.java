onTouch(View v, MotionEvent event){ 
  if(v.getId() == R.id.myButtonId){
     if(event.getAction() == MotionEvent.ACTION_DOWN){
       // TODO change button text to "good"
     }else if(event.getAction() == MotionEvent.ACTION_UP){
       // TODO change button text to "jump"
     }
  }
}