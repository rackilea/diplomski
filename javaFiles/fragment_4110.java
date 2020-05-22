series1.setPointLabeler(new PointLabeler() {
    DecimalFormat df = new DecimalFormat("###.###");

    @Override
    public String getLabel(XYSeries series, int index) {
        return df.format(series.getY(index));
    }
});