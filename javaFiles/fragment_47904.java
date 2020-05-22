@Override
public void paintComponents(Graphics g) {
    super.paintComponents(g);
    g.drawImage(bgImage, 0, 0, null);
    System.out.println("repaint");
}