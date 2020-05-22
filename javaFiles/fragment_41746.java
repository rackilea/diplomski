class Face {

    private Point location;

    Face(Point location) {
        this.location = location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(Point location) {
        this.location = location;
    }

    public void draw(Graphics2D g) {
        /* save this to reset it after painting. */
        AffineTransform transform = g.getTransform();        

        AffineTransform move = AffineTransform.getTranslateInstance(
                location.getX(), location.getY());
        g.setTransform(move);

        //Construct the alien face
        //Draw the  head
        g.setColor(Color.DARK_GRAY); // explicitly set a color
        Ellipse2D.Double head = new Ellipse2D.Double(5, 80, 100, 150);
        g.fill(head);
        g.setColor(Color.LIGHT_GRAY);
        g.draw(head);

        //Draw the set of eyes
        g.setColor(Color.GREEN);
        Rectangle eye = new Rectangle(25, 140, 15, 15);
        g.fill(eye);
        eye.translate(50, 0);
        g.fill(eye);

        //Draw the mouth
        Line2D.Double mouth = new Line2D.Double(30, 180, 80, 180);
        g.setColor(Color.RED);
        g.draw(mouth);

        //Draw the greeting
        g.setColor(Color.BLUE);
        g.drawString("Hello, World!", 20, 245);

        // reset the transform to the original (so later painting is not moved)
        g.setTransform(transform);
    }
}