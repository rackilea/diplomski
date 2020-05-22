private void jLabel2MouseDragged(java.awt.event.MouseEvent evt)  {                                     

  Point p = SwingUtilities.convertPoint(evt.getComponent(), evt.getPoint(), getContentPane());
  int x=p.x;
  int y=p.y;

  jLabel2.setLocation(x-120, y-120);
  jLabel2.repaint();

}