public void generateChart() {
    for (int i = 0; i < engines.size(); i++) {
        XYChart.Series series = new XYChart.Series();
        series.setName(engines.get(i).toString());
        for (int j = 0; j < parameters.size(); j++) {
            series.getData().add(new XYChart.Data(parameters.get(j).toString(), param.get(i).get(j)));
        }
        lineChart.getData().add(series);
    }
    System.out.println(lineChart);
}