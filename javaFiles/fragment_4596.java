private static Line2D.Double line = new Line2D.Double();
private static int count = 100;

@Override
public void paintComponent(Graphics g){
    super.paintComponent(g);
    // use temp line to not effect original line
    Line2D.Double tempLine = line;
    for (int q = 0; q < count; q++){
        g.drawLine((int)tempLine.x1, (int)tempLine.y1, (int)tempLine.x2, (int)tempLine.y2);
        tempLine = new Line2D.Double(tempLine.x1+5, tempLine.y1+5, 
            tempLine.x2+10, tempLine.y2+10);
    }
}