@Override
public void start(Stage primaryStage) {
    Rectangle rect = new Rectangle(100, 100);
    Rectangle rect2 = new Rectangle(200, 200, 100, 100);

    rect.setOnDragDetected(evt -> {
        // start full drag
        rect.startFullDrag();
    });
    rect2.setOnDragDetected(evt -> {
        // start full drag
        rect2.startFullDrag();
    });

    // print something when mouse enters the rects during a drag event.
    rect.setOnMouseDragEntered(evt -> System.out.println("enter"));
    rect2.setOnMouseDragEntered(evt -> System.out.println("enter"));

    Pane root = new Pane(rect, rect2);
    Scene scene = new Scene(root);

    primaryStage.setScene(scene);
    primaryStage.show();
}