public Point DrawTree(Graphics g, int StartWidth, int EndWidth, int StartHeight, int Level, Node node)
{
    String data = String.valueOf(node.getValue());
    g.setFont(new Font("Tahoma", Font.BOLD, 20));
    FontMetrics fm = g.getFontMetrics();
    int dataWidth = fm.stringWidth(data);

    // Calculate position to draw text string
    Point textPos = new Point((StartWidth + EndWidth) / 2 - dataWidth / 2, StartHeight + Level / 2);
    g.drawString(data, textPos.x, textPos.y);

    if (node.getLeft() != null) {
        Point child1 = DrawTree(g, StartWidth, (StartWidth + EndWidth) / 2, StartHeight + Level, Level, node.getLeft());
        // Draw line from this node to child node
        drawLine(g, textPos, child1);
    }
    if (node.getRight() != null) {
        Point child2 = DrawTree(g, (StartWidth + EndWidth) / 2, EndWidth, StartHeight + Level, Level, node.getRight());
        // Draw line from this node to child node
        drawLine(g, textPos, child2);
    }
    // Return position for parent to use
    return textPos;
}

public void drawLine(Graphics g, Point p1, Point p2)
{
   g.drawLine(p1.x, p1.y, p2.x, p2.y);
}