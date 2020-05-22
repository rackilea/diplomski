public void mouseDragged(MouseEvent e) {
  int x = e.getX();
  int y = e.getY();
  String xstring = String.valueOf(x);
  String ystring = String.valueOf(y);
  frame.setTitle("dragged - " + xstring + ", " + ystring);
}