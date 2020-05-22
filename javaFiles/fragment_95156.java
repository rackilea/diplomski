private ArrayList<Point> points = new ArrayList<Point>();

//...

public void mouseDragged(MouseEvent arg0) {
    points.add(arg0.getPoint());
    repaint(); //request Swing to refresh display as soon as it can
}

//...

protected void paintComponent(Graphics g)
{
    super.paintComponent(g);

    for (int i = 0; i < points.size() - 2; i++)
    {
        Point p1 = points.get(i);
        Point p2 = points.get(i + 1);

        g.drawLine(p1.x, p1.y, p2.x, p2.y);
    }
}