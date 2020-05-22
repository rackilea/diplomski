m_vis.setRendererFactory(new RendererFactory() {
    Renderer yAxisRenderer = new AxisRenderer(Constants.LEFT, Constants.TOP);
    Renderer xAxisRenderer = new AxisRenderer(Constants.CENTER, Constants.FAR_BOTTOM);
    Renderer barRenderer = new ShapeRenderer() {
        protected Shape getRawShape(VisualItem item) {
            double x = item.getX();
            double y = item.getY();
            if (Double.isNaN(x) || Double.isInfinite(x))
                x = getInsets().left + axisWidth + totalBarWidth / 2;
            if (Double.isNaN(y) || Double.isInfinite(y))
                y = 0;

            double width = totalBarWidth / (barCount + 1) - barGap;
            double height = getHeight() - getInsets().bottom - axisHeight - y;
            x -= width / 2;

            return rectangle(x, y, width, height);
        }
    };

    public Renderer getRenderer(VisualItem item) {
        return item.isInGroup("yAxis") ? yAxisRenderer :
               item.isInGroup("xAxis") ? xAxisRenderer :
               barRenderer;
    }
});