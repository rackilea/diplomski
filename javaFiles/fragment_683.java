@Override
public void start(Stage pPrimaryStage) throws Exception
{
    final Label graphic = new Label();
    graphic.getStyleClass().add("html-editor-cut");
    pPrimaryStage.setScene(new Scene(new BorderPane(graphic), 500, 500));
    pPrimaryStage.show();
}