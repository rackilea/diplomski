class ScreenCapture {
  class CaptureButtonListener implements ClickListener {
     public void onClick( ClickEvent click ) {
       //..capture
       pressCount++;
     }
  }

  Button button = new Button("capture");
  int pressCount = 0;

  void addListeners() {
    button.addClickListener( new CaptureButtonListener() );
  }
}