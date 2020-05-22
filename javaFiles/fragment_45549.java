public class WhiteBoard extends JPanel {
@Override
public void paintComponent(Graphics g) {
super.paintComponent(g);

Graphics2D g2 = (Graphics2D) g;
g2.setColor(Color.red);
g2.fillRect(0, 0, getWidth(), getHeight());
}
}