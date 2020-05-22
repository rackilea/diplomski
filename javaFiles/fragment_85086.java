public class MyMIDlet extends MIDlet {
  public void startApp() {
    Canvas c = new MyCanvas();
    Display.getDisplay(this).setCurrent(c);
  }

  ...
}