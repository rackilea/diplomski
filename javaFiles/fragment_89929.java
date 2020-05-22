chartPanel.addChartMouseListener(new ChartMouseListener() {

    @Override
    public void chartMouseClicked(ChartMouseEvent event) {
        ChartEntity entity = event.getEntity();
        System.out.println(entity);
    }

    @Override
    public void chartMouseMoved(ChartMouseEvent event) {
    }
});