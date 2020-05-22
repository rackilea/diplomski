public class Drawing extends JFrame {
  JPanel drawingPanel;
  ...........
  public Drawing (){
    drawingPanel = new MyPanel();
    drawingPanel.setPreferredSize(new Dimension(600,600));
    add(drawingPanel);
  }
}

public class MyPanel extends JPanel {
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    myBackgroundRoutine(g2);
  }
}