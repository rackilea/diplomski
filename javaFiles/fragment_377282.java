@Override
public void paint(Graphics g) {
    super.paint(g);
    Graphics2D g2d = (Graphics2D) g;

    // assuming you want it behind everything else
    // drawn to g2d after this point
    g.drawImage(Background, 0, 0, null);

    DoAnimation();
    if (bInGame) {
        PlayGame(g2d);
    } else {
        ShowIntroScreen(g2d);
    }
    g.drawImage(ii, 5, 5, this);
    Toolkit.getDefaultToolkit().sync();
    g.dispose();
}