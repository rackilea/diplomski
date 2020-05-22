public void run() {
    Platform.runLater(new Runnable() {

        @Override
        public void run() {
                // "expensive calculation"
            Series series = plot.getSeries();
            double xOffset = series.valueAxis().getLeft();
            double yOffset = series.keyAxis().getLeft();
            double yScale = height / series.keyAxis().range();
            double xScale = width / series.valueAxis().range();

            plot.getPoints().clear();
            for (Map.Entry<Double, Double> item : series.data().entrySet()) {
                double x = item.getValue();
                double y = item.getKey();
                plot.getPoints().addAll((x - xOffset) * xScale, (y - yOffset) * yScale);
            }
        }
    });
}