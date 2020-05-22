public class ScreenCapture {
  public static class CaptureButtonListener implements ClickListener {
    protected ScreenCapture controller;
    public CaptureButtonListener( ScreenCapture controller ) {
      this.controller = controller;
    }

     public void onClick( ClickEvent click ) {
       //..capture
       controller.pressCount++;
     }
  }

  Button button = new Button("capture");
  int pressCount = 0;

  public void captureRequested() {
    //do capture...
    pressCount++;
  }

  void addListeners() {
    button.addClickListener( new CaptureButtonListener(this) );
  }
}