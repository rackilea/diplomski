public void start(Stage stage) throws Exception {
    BorderPane root = new BorderPane();
    root.setCenter(new Rectangle(100,100, Color.RED));
    root.setLeft(new Rectangle(10,10, Color.BLUE));
    root.setRight(new Rectangle(10,10, Color.CYAN));

    stage.setScene(new Scene(root,300,300));

    stage.show();
}