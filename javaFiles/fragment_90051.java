@Override
public void start(Stage primaryStage) {
    double w = 10.5;
    double h = 10.5;

    Pane pane = new Pane();

    for (int i = 0; i < 57; i++) {
        for (int j = 0; j < 57; j++) {
            double x = Math.floor(i * w);
            double y = Math.floor(j * h);
            double nx = Math.floor((i + 1) * w);
            double ny = Math.floor((j + 1) * h);
//            double x = i * w;
//            double y = j * h;
//            double nx = (i + 1) * w;
//            double ny = (j + 1) * h;
            Rectangle rect = new Rectangle(x, y, nx - x, ny - y);
            rect.setFill(Color.BLACK);
            pane.getChildren().add(rect);
        }
    }

    primaryStage.setScene(new Scene(pane, 600, 600));
    primaryStage.show();
}