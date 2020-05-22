private Rectangle[][] rects = new Rectangle[3][3];

private void moveDown() {
    for (Rectangle[] column : rects) {
        for (Rectangle r : column) {
            if (r != null) {
                r.setY(r.getY() + 5);
            }
        }
    }
}

@Override
public void start(Stage primaryStage) {
    Pane root = new Pane();
    for (int j = 0; j < rects.length; j++) {
        Rectangle[] column = rects[j];
        for (int i = 0; i < column.length; i++) {
            Rectangle rect = new Rectangle(20, 20);
            rect.setX(j * 25);
            rect.setY(i * 25);
            root.getChildren().add(rect);
            column[i] = rect;
        }
    }
    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), new EventHandler<ActionEvent>() {

        boolean movingRight = true;

        @Override
        public void handle(ActionEvent event) {
            double maxX = Double.NEGATIVE_INFINITY;
            double minX = Double.POSITIVE_INFINITY;
            outer:
            for (int i = rects.length - 1; i >= 0; i--) {
                for (Rectangle r : rects[i]) {
                    if (r != null) {
                        maxX = r.getX() + r.getWidth();
                        break outer;
                    }
                }
            }
            outer:
            for (Rectangle[] col : rects) {
                for (Rectangle r : col) {
                    if (r != null) {
                        minX = r.getX();
                        break outer;
                    }
                }
            }
            if (movingRight) {
                if (maxX + 5 > 150) {
                    moveDown();
                    movingRight = false;
                    return;
                }
            } else {
                if (minX - 5 < 0) {
                    moveDown();
                    movingRight = true;
                    return;
                }
            }
            double dx = movingRight ? 5 : -5;
            for (Rectangle[] column : rects) {
                for (Rectangle r : column) {
                    if (r != null) {
                        r.setX(r.getX() + dx);
                    }
                }
            }
        }

    }));
    timeline.setCycleCount(Animation.INDEFINITE);
    timeline.play();

    Scene scene = new Scene(root, 150, 600);

    primaryStage.setScene(scene);
    primaryStage.show();
}