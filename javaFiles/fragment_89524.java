@Override
public void start(Stage primaryStage) {
    Image image = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/e/ec/Mona_Lisa%2C_by_Leonardo_da_Vinci%2C_from_C2RMF_retouched.jpg/687px-Mona_Lisa%2C_by_Leonardo_da_Vinci%2C_from_C2RMF_retouched.jpg");
    GridPane images = new GridPane();

    for (int x = 0; x < 2; x++) {
        for (int y = 0; y < 2; y++) {
            images.add(new ImageView(image), x, y);
        }
    }

    Pane root = new Pane(images);
    images.setManaged(false);

    class DragHandler implements EventHandler<MouseEvent> {

        double startX;
        double startY;
        boolean dragging = false;

        @Override
        public void handle(MouseEvent event) {
            if (dragging) {
                double newX = (event.getX() + startX) % image.getWidth();
                double newY = (event.getY() + startY) % image.getHeight();

                if (newX > 0) {
                    newX -= image.getWidth();
                }

                if (newY > 0) {
                    newY -= image.getHeight();
                }
                images.setLayoutX(newX);
                images.setLayoutY(newY);
            }
        }

    }

    DragHandler handler = new DragHandler();
    root.setOnMouseDragged(handler);
    root.setOnDragDetected(evt -> {
        images.setCursor(Cursor.MOVE);
        handler.startX = images.getLayoutX() - evt.getX();
        handler.startY = images.getLayoutY() - evt.getY();
        handler.dragging = true;
    });

    root.setOnMouseReleased(evt -> {
        handler.dragging = false;
        images.setCursor(Cursor.DEFAULT);
    });

    Scene scene = new Scene(root, 400, 400);

    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
}