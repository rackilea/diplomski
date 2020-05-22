@Override
public void start(Stage primaryStage) {
    Circle character = new Circle(100, 100, 20, Color.RED);
    Rectangle background = new Rectangle(2000, 200, new LinearGradient(0, 0, 100, 0, false, CycleMethod.REPEAT, new Stop(0, Color.WHITE), new Stop(100, Color.BLUE)));
    Group group = new Group(background, character);
    group.setManaged(false);

    Pane root = new Pane(group);
    root.setPrefSize(200, 200);

    Scene scene = new Scene(root);
    scene.setOnKeyPressed(evt -> {
        double direction = -1;
        switch (evt.getCode()) {
            case RIGHT:
                direction = 1;
            case LEFT:
                double delta = direction * 10;
                character.setTranslateX(character.getTranslateX() + delta);
                group.setTranslateX(group.getTranslateX() - delta);
        }
    });

    primaryStage.setScene(scene);
    primaryStage.show();
}