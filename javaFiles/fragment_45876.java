public void mousePressed(MouseEvent e)
{
    for (Ellipse2D.Double ellipse: shapes)
    {
        if (ellipse.contains(e.getPoint())
        {
            table.requestFocusInWindow();
            Point p = shapesMap.get(ellipse);
            table.editCellAt(p.x, p.y);
            break;
        }
    }
}