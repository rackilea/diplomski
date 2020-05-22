for (int i = 0 ; i <= 400; i++) {
    double lambda = 1.0 * i / 100 ;
    double x = 0.5 ;
    for (int j = 0 ; j < 100 ; j++) {
        x = lambda * x * (1-x);
    }
    for (int j = 0 ; j < 50; j++) {
        Data<Number, Number> data = new Data<>(lambda, x);
        Region plotpoint = new Region();
        plotpoint.setShape(new Circle(0.5));
        data.setNode(plotpoint);
        series.getData().add(data);
        x = lambda * x * (1-x);
    }
}