@Override
public void paint(Graphics g) {
    super.paint(g);
    if (towns.size() > 0)
        for (Town t : towns)
            g.fillRect(t.getX() - 10, t.getY() - 10, 20, 20);
}