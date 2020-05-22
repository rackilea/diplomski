@Override
public void start(Stage primaryStage) {

    TextFlow textFlow = new TextFlow();
    textFlow.setOnMouseClicked(ev -> {
        if(ev.getTarget() instanceof Text) {
            Text clicked = (Text) ev.getTarget();
            System.out.println(clicked);
        }
    });

    IntStream.range(0, 500).mapToObj(Integer::toString).map(Text::new).forEach(textFlow.getChildren()::add);

    BorderPane borderpane = new BorderPane(textFlow);
    borderpane.setPadding(new Insets(20));

    Scene scene = new Scene(borderpane, 400, 400);
    primaryStage.setScene(scene);
    primaryStage.show();
}