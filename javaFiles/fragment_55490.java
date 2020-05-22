public class MyApp extends Application {

    private final ObjectProperty<Cursor> cursor = new SimpleObjectProperty<>(Cursor.DEFAULT);

    @Override
    public void start(Stage primaryStage) {
        Parent root =  ... ;
        // ...

        someButton.setOnAction(event -> {
            Parent stageRoot = ... ;
            Stage anotherStage = new Stage();
            anotherStage.setScene(createScene(stageRoot, ..., ...));
            anotherStage.show();
        });

        primaryStage.setScene(createScene(root, width, height));
        primaryStage.show();

    }

    private static Scene createScene(Parent root, double width, double height) {
        Scene scene = new Scene(root, width, height);
        scene.cursorProperty().bind(cursor);
        return scene ;
    }
}