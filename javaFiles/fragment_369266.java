float x,y; //CONSTANTS FOR WHERE YOU WANT YOUR BAR TO BE
float baseWidth; // This is the width of one block. 
                 //Number of blocks together will be your rectangle
float nwidth;     //This is the number of blocks varying according to amplitude
float height;    //CONSTANT HEIGHT
Paint color=new Paint();     

//For drawing meter
public void onDraw(Canvas c){
  changeColorAndSize();
  Rect rect = new Rect(x, y, x + (baseWidth*nwidth), y + height);
  shapeDrawable.setBounds(rect);
  shapeDrawable.getPaint().set(paint);
  shapeDrawable.draw(canvas);

}

public void changeColorAndSize(){
       double amp=getAmplitude();
       nWidth=amp;
       paint.setARGB (a, r*(Integer.parseInt(amp)), g, b);
      //This will change the redness of the bar. a,g and b will have to be set by you

}

public double getAmplitude() {
        if (mRecorder != null)
                return  (mRecorder.getMaxAmplitude());
        else
                return 0;
}