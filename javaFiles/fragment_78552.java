//other stuff/methods/listener part
private MouseListener onMouseClickText = new MouseListener() {
  @Override
  public void mouseUp(MouseEvent arg0) {
    ((Text) arg0.widget).setText("");
  }
...
}