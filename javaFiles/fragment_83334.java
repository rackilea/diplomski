class CustomLegendGraphic extends LegendGraphic {
    String label;

    public CustomLegendGraphic(Shape shape, Paint fillPaint, String label) {
        super(shape, fillPaint);
        this.label = label;
    }

    @Override
    public Object draw(Graphics2D g2, Rectangle2D area, Object params) {
        Object result = super.draw(g2, area, params);

        area = trimMargin(area);
        Point2D location = RectangleAnchor.coordinates(area, this.getShapeLocation());

        TextBlock textBlock = TextUtilities.createTextBlock(label, getItemFont(), Color.white);
        textBlock.draw(g2, (float)location.getX(), (float)location.getY(), TextBlockAnchor.CENTER);

        return result;
    }
}