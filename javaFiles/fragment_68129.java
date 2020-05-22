public class MainActivity extends Activity implements OnTouchListener {

...
btn_1.setOnTouchListener(this);
...

@Override
public boolean onTouch(View arg0, MotionEvent arg1) {
    if (arg1.getAction()==MotionEvent.ACTION_DOWN){

        doPressDown();          
    }
    else if (arg1.getAction()==MotionEvent.ACTION_UP){

        doPressRelease();
    }

    return true;
}  

 private void doPressDown(){

 isPressed = true;

 new Thread(){
 public void run() {

 while(isPressed == true){
       // here we increment till user release the button
     }
   }

 private void doPressRelease(){
     isPressed = false;
 }
}