@Override
public void start(Stage pPrimaryStage) throws Exception
{
    final StackPane graphic = new StackPane();
    graphic.setMaxSize(25, 25);
    graphic.getStyleClass().addAll("default-color3", "chart-symbol");

    pPrimaryStage.setScene(new Scene(new BorderPane(graphic), 500, 500));
    pPrimaryStage.show();
}