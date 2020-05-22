plot.addLayer(new StandardDialRange(3 * maximumValue / 4, maximumValue, Color.red) {

    @Override
    public void draw(Graphics2D g2, DialPlot plot, Rectangle2D frame, Rectangle2D view) {
        …
        g2.setPaint(this.getPaint());
        g2.setStroke(new BasicStroke(4.0f));
        g2.draw(arcInner);
        g2.draw(arcOuter);
    }
});