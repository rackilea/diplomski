tChart1.addChartPaintListener(new ChartPaintAdapter() {

    @Override
    public void chartPainted(ChartDrawEvent e) {
        Axis leftAxis = tChart1.getAxes().getLeft();
        TextShape label = new TextShape(tChart1.getChart());
        leftAxis.drawAxisLabel(leftAxis.getPosition(), leftAxis.calcPosValue(500), 0, "CLOSE", label);
    }
});