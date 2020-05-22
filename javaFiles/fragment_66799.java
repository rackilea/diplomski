// CLASS BEING IMPORTED
public abstract class TouchableSpan extends ClickableSpan {

  // IMPLEMENT SET TAG FUNCTION HERE??

  //COMMENT: YES, LIKE THIS: CAN BE ANY FUNCTION U LIKE

  private String myCustomVar;

  public String getMyVar(){
  return this.myCustomVar;
  }

  public void setMyVar(String myVari){
  this.myCustomVar = myVari;
  return;
  }

}

// CODE ON ACTIVITY
TouchableSpan touchableSpan = new TouchableSpan() {

  @Override
  public void onClick(View widget) {
      this.setPressed(true);

      // GET TAG INFO HERE. BUT HOW?

      //COMMENT: LIKE THIS: 

      String extravar = touchableSpan.getMyVar();
      Log.d("TEST", extravar);
  }

  // SET TAG HERE? BUT HOW?

  COMMENT: NOT HERE. SEE BELOW

  private boolean mIsPressed;

  public void setPressed(boolean isSelected) {
      mIsPressed = isSelected;
  }

  @Override
  public void updateDrawState(TextPaint ds) {
      super.updateDrawState(ds);
      ds.setColor(Color.BLACK);
      ds.bgColor = mIsPressed ? selectedHlColor : 0xffeeeeee;
      ds.setUnderlineText(false);
  }
}

//COMMENT: SET YOUR VARIABLE/TAG HERE:

touchableSpan.setMyVar("HOLALA");

spannablesstringbuilder.setSpan(touchableSpan, index+2, index2, 0);