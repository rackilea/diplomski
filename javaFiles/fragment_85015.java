//As kleopatra says,
//public Image getDragImage() {
//    return null;
//}
public boolean importData(TransferHandler.TransferSupport info) {
    //...
    //HERE IS THE CODE TO SET THE DRAG IMAGE
    //XXX: this.setDragImage(makeImageFromString(data));
    //...
}
@Override public int getSourceActions(JComponent c) {
  System.out.println("getSourceActions");
  this.setDragImage(makeImageFromString(c));
  return COPY;
}

FontRenderContext frc = new FontRenderContext(null, true, true);
JPanel p = new JPanel();
public BufferedImage makeImageFromString(JComponent c) {
  int width = 100;
  int height = 40;
  BufferedImage br = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
  Graphics g = br.getGraphics();
  g.setColor(Color.RED);
  g.fillRect(0, 0, width, height);

//*
  JList l = (JList)c;
  ListCellRenderer r = l.getCellRenderer();
  Component comp = r.getListCellRendererComponent(
      l, l.getSelectedValue(), l.getSelectedIndex(), false, false);
  SwingUtilities.paintComponent(g, comp, p, 0, 0, width, height);
/*/
  String s = "aaaa";
  Rectangle rect = c.getFont().getStringBounds(s, frc).getBounds();
  int tx = (width  - rect.width)/2  - rect.x;
  int ty = (height - rect.height)/2 - rect.y;
  g.setColor(Color.BLACK);
  g.drawString(s, tx, ty);
  System.out.println("made image from " + s);
//*/
  g.dispose();
  return br;
}