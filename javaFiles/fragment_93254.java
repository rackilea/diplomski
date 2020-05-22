@Override
public boolean onTouch(View v, MotionEvent event){
    if (event.getAction() == MotionEvent.ACTION_UP){
        sing = new Sing();
        sing.create();
        sing.sound("sound.ogg");
    } 
    return true;
    }