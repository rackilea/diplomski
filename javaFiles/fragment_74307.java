for (Line2D l : lines)
{
    Point2D p1 = new Point2D.Double(l.getX1(), l.getY1());
    Point2D p2 = new Point2D.Double(l.getX2(), l.getY2());
    p1 = atg.transform(p1, null);
    p2 = atg.transform(p2, null);
    contentStream.moveTo((float) p1.getX(), page.getMediaBox().getHeight() - (float) p1.getY());
    contentStream.lineTo((float) p2.getX(), page.getMediaBox().getHeight() - (float) p2.getY());
    contentStream.stroke();
}