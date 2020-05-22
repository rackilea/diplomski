public class cPan extends JPanel implements MouseListener {
  @Override
  public void mouseClicked(MouseEvent e) {
    Point p = e.getPoint();
    // or
    int x = e.getX();
    int y = e.getY();
  }
}