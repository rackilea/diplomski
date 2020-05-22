public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            BorderPane root = new BorderPane();
            Scene scene = new Scene(root,400,400);

            Button b = new Button("Open deck");
            b.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    Stage popupStage = new Stage();

                    popupStage.initOwner(primaryStage);
                    popupStage.initStyle(StageStyle.UNDECORATED);
                    Scene sc = new Scene(new ScrollPane(), 300, 300);
                    popupStage.setScene(sc);

                    popupStage.focusedProperty().addListener(new ChangeListener<Boolean>() {

                        @Override
                        public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue,
                                Boolean newValue) {
                            if(!newValue)
                                popupStage.close();

                        }
                    });

                    popupStage.show();

                }
            });

            root.setCenter(b);


            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}