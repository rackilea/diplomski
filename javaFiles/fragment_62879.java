BarChart<String, Number> chart = new BarChart<>(new CategoryAxis(), new NumberAxis());

    final XYChart.Series<String, Number> series1 = new XYChart.Series<>();
    chart.getData().addAll(series1);

    SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    Date date = new Date();
    for (int i = 0; i <= 10; i += 1) {
        date.setTime(date.getTime() + i * 11111);
        series1.getData().add(new XYChart.Data(dateFormat.format(date), Math.random() * 500));
    }