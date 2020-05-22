public class Main extends Application {

    @Override
    public void start(Stage stage) {
        VBox cbox = new VBox();
        cbox.getChildren().addAll(
                new Label("Test ABC"),
                new Label("Test CDE"),
                new Label("Test DEF"),
                new Label("Test EFG")
        );
        TabPane tabpane = new TabPane();

        TitledPane titledpane = new TitledPane("Test collapsible",cbox);
        titledpane.setExpanded(false);
        //The line below should solve the issue
        titledpane.setOnMouseClicked(event -> tabpane.requestLayout());

        VBox box = new VBox();
        box.getChildren().addAll(
                new Label("Test"),
                new Label("Test2"),
                new Label("Test3"),
                titledpane,
                new Label("Test4")
        );

        tabpane.getTabs().addAll(
                new Tab("First tab",box),
                new Tab("Faire Valoir",new Label("Choucroute"))
        );

        box.heightProperty().addListener((arg0, arg1, arg2) -> {
            System.err.println("Height changed "+arg1+" <- "+arg2);
            SingleSelectionModel<Tab> selectionmodel = tabpane.getSelectionModel();//Unused
        });

        ScrollPane scrollPane = new ScrollPane(tabpane);
        stage.setScene(new Scene(scrollPane));
        stage.show();
    }
}