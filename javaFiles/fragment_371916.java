private static Area[] split(Area a, Point2D p0, Point2D p1, Graphics2D g)
{
    // Compute the angle of the line to the x-axis
    double dx = p1.getX() - p0.getX();
    double dy = p1.getY() - p0.getY();
    double angleRadToX = Math.atan2(dy, dx); 

    // Align the area so that the line matches the x-axis
    AffineTransform at = new AffineTransform();
    at.rotate(-angleRadToX);
    at.translate(-p0.getX(), -p0.getY());
    Area aa = a.createTransformedArea(at);

    // Compute the upper and lower halves that the area
    // has to be intersected with
    Rectangle2D bounds = aa.getBounds2D();

    double half0minY = Math.min(0, bounds.getMinY());
    double half0maxY = Math.min(0, bounds.getMaxY());
    Rectangle2D half0 = new Rectangle2D.Double(
        bounds.getX(), half0minY, 
        bounds.getWidth(), half0maxY-half0minY);

    double half1minY = Math.max(0, bounds.getMinY());
    double half1maxY = Math.max(0, bounds.getMaxY());
    Rectangle2D half1 = new Rectangle2D.Double(
        bounds.getX(), half1minY, 
        bounds.getWidth(), half1maxY-half1minY);

    // Compute the resulting areas by intersecting
    // the original area with both halves, and 
    // transform them back to their initial position
    Area a0 = new Area(aa);
    a0.intersect(new Area(half0));

    Area a1 = new Area(aa);
    a1.intersect(new Area(half1));

    try
    {
        at.invert();
    }
    catch (NoninvertibleTransformException e)
    {
        // Always invertible
    }
    a0 = a0.createTransformedArea(at);
    a1 = a1.createTransformedArea(at);

    // Debugging output
    if (g != null)
    {
        g.setColor(Color.GRAY);
        g.draw(bounds);

        g.setColor(Color.RED);
        g.draw(aa);

        g.setColor(Color.YELLOW.darker());
        g.draw(half0);

        g.setColor(Color.MAGENTA);
        g.draw(half1);

        g.setColor(Color.BLUE.darker());
        g.fill(AffineTransform.getTranslateInstance(400, -20).
            createTransformedShape(a0));

        g.setColor(Color.BLUE.brighter());
        g.fill(AffineTransform.getTranslateInstance(400, +20).
            createTransformedShape(a1));
    }

    return new Area[] { a0, a1 };
}