protected void paintComponent(Graphics g)
{
    // fill and color
    super.paintComponent(g);
    StopWatch sw = new StopWatch();   // <-- HERE
    Graphics2D g2 = (Graphics2D)g;
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
    g2.setPaint(Color.red);
    g2.fill(circle);
    g2.setPaint(Color.red);
    Point p1 = points[0];
    for(int j = 1; j <= points.length; j++)
    {
        Point p2 = points[j % points.length];
        g2.drawLine(p1.x, p1.y, p2.x, p2.y);
        // Line coordinates
        p1 = p2;
    }
    long time = sw.elapsedTime();  // <-- HERE
    System.out.println("Circle took " + time + "ms to draw.");
}