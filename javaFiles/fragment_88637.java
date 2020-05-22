g.drawString(lineNumber, x, y);  

//  Code to paint an arrow

if (isCurrentLine(rowStartOffset))
{
    int height = fontMetrics.getAscent() - fontMetrics.getDescent();

    Polygon triangle = new Polygon();
    triangle.addPoint(borderGap, y);
    triangle.addPoint(borderGap, y - height);
    triangle.addPoint(borderGap + 10, y - height / 2);
    Graphics2D g2d = (Graphics2D)g.create();
    g2d.fill( triangle );
    g2d.dispose();
}