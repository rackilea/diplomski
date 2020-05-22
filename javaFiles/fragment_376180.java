protected void undecorate(LineChart chart) {
    chart.setLegendVisible(false);
    chart.setCreateSymbols(false);
    chart.setHorizontalGridLinesVisible(false);
    chart.setHorizontalZeroLineVisible(false);
    chart.setVerticalGridLinesVisible(false);
    chart.setVerticalZeroLineVisible(false);
    undecorateAxis(chart.getXAxis());
    undecorateAxis(chart.getYAxis());
}

protected void undecorateAxis(Axis axis) {
    // trying to hide: not working
    // xAxis.setVisible(false);
    // configure all ticks/label to not visible doesn't work
    // if (axis instanceof ValueAxis)
    //    ((ValueAxis<?>) axis).setMinorTickVisible(false);
    // axis.setTickLabelsVisible(false);
    //axis.setTickMarkVisible(false);
    // remove from parent does work
    Pane parent = (Pane) axis.getParent();
    parent.getChildren().removeAll(axis);
}