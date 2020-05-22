public AppletMouseListener extends MouseAdapter {
  private final JApplet theApplet;
  private final Container[][] a;
  private final int i;
  private final int j;

  public AppletMouseListener(JApplet theApplet, Container[][] a, int i, int k) {
    this.theApplet = theApplet;
    this.a = a;
    this.i = i;
    this.k = k;
  }

  @Override
  public void mousePressed(MouseEvent e) {
    JComponent temp = a[i-1][k];
    a[i-1][k] = a[i][k];
    a[i][k] = temp;
    //some
    //code here 
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    theApplet.invalidate();
    theApplet.revalidate();
    theApplet.repaint();
  }
}