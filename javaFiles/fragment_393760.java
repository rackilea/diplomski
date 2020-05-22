public class CirclePanel extends JPanel {
@Override
protected void paintComponent(Graphics g) {
    //Adding  super.paintComponent....  
    super.paintComponent(g);

    g.drawOval(0, 0, g.getClipBounds().width, g.getClipBounds().height);
    }
}