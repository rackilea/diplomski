public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextField txt1= new TextField("text 1");
        TextField txt2= new TextField("text 2 ");
        Button btn= new Button("hello");

        StackPane root = new StackPane();
        VBox vBox= VBoxBuilder.create()
                .children(txt1, btn, txt2)
                .build();

        txt1.focusedProperty().addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1) {
                if (t1) {
                    System.ou.prinln("Focus In");
                } else {
                    System.ou.prinln("Focus Out");
                }

            }
        });

        root.getChildren().add(vBox);       
        Scene scene = new Scene(root, 500, 400);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}