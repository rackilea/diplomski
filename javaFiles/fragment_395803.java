public class MyInputElem extends InputElement{

  private boolean focus = false;

  @Listen("onFocus")
  public void focus(){
    focus = true;
  }

  @Listen("onBlur")
  public void blur(){
    focus = flase;
  }

  public boolean isFocus(){
    return focus;
  }
}