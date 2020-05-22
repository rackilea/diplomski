m_vis.setRendererFactory(new RendererFactory() {
    Renderer yAxisRenderer = new AxisRenderer(Constants.LEFT, Constants.TOP);
    Renderer xAxisRenderer = new AxisRenderer(Constants.CENTER, Constants.FAR_BOTTOM);
    Renderer barRenderer = new ShapeRenderer();

    public Renderer getRenderer(VisualItem item) {
        return item.isInGroup("yAxis") ? yAxisRenderer :
               item.isInGroup("xAxis") ? xAxisRenderer :
               barRenderer;
    }
});