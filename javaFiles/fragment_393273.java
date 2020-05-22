XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer(false, true) {
    @Override
    public Paint getItemFillPaint(int row, int col) {
        return scale.getPaint(dataset.getZValue(row, col));
    }
    …
};