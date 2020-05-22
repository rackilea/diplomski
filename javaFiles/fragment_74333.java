public class Main extends Application {

    TabPane tabPane;
    private ToggleGroup toggleGroup;

    @Override
    public void start(Stage primaryStage) {

        Group root = new Group();
        Scene scene = new Scene(root, 700, 400, Color.WHITE);

        primaryStage.setTitle("Tabs Test");

        toggleGroup = new ToggleGroup();
        toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                if (newValue == null)
                    toggleGroup.selectToggle(oldValue);
                else
                    tabPane.getSelectionModel().select((Tab) newValue.getUserData());
            }
        });

        tabPane = new TabPane();
        tabPane.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

        VBox vboxToggleOuterContainer = new VBox();
        HBox hboxToggleFirstRow = new HBox();
        HBox hboxToggleSecondRow = new HBox();

        vboxToggleOuterContainer.getChildren().addAll(hboxToggleFirstRow, hboxToggleSecondRow);

        for (int i = 0; i < 20; i++) {
            Tab tab = new Tab();
            tab.setText("Tab " + i);
            HBox hbox = new HBox();
            hbox.getChildren().add(new Label("Tab " + i));
            tab.setContent(hbox);
            tabPane.getTabs().add(tab);

            ToggleButton tb = new ToggleButton("Tab" + i);
            tb.setToggleGroup(toggleGroup);
            tb.setUserData(tab);

            if (i < 10)
                hboxToggleFirstRow.getChildren().add(tb);
            else
                hboxToggleSecondRow.getChildren().add(tb);
        }

        toggleGroup.selectToggle(toggleGroup.getToggles().get(0));

        VBox vbox = new VBox();
        vbox.getChildren().addAll(vboxToggleOuterContainer, tabPane);
        vbox.fillWidthProperty().set(true);
        root.getChildren().add(vbox);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}