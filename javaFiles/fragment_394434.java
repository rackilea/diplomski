public class Demo extends Application {

    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root);
        stage.setScene(scene);

        TextField myTextField = new TextField("default");
        Rectangle myRectangle = new Rectangle();
        myRectangle.setHeight(30);
        myRectangle.setFill(Color.AQUA);
        myRectangle.widthProperty().bind(myTextField.widthProperty());

        final VBox hb = new VBox(10);
        hb.setPadding(new Insets(5));
        hb.getChildren().addAll(myTextField, myRectangle);
        scene.setRoot(hb);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}