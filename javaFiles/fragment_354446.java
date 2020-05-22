@Override
public void start(Stage primaryStage) throws Exception {
    // create group containing scene that remains in place
    Circle target1 = new Circle(100, 200, 20, Color.RED);
    Circle target2 = new Circle(150, 100, 20, Color.RED);
    Group targetGroup = new Group(target1, target2);

    // create group that will be transformed
    Circle c1 = new Circle(30, 30, 20, Color.BLUE);
    Circle c2 = new Circle(400, 400, 20, Color.BLUE);
    Group g = new Group(c1, c2);

    Scene scene = new Scene(new Pane(targetGroup, g), 500, 500);

    // register handler for swapping between transformed/untransformed scene on button click
    scene.setOnMouseClicked(new EventHandler<MouseEvent>() {

        boolean transformed;
        final Translate translate = new Translate();
        final Scale scale = new Scale();
        final Rotate rotate = new Rotate();

        {
            // add transforms to transformation target            
            g.getTransforms().addAll(rotate, scale, translate);
        }

        @Override
        public void handle(MouseEvent event) {
            if (transformed) {
                // reset transforms to identity
                translate.setX(0);
                translate.setY(0);
                scale.setX(1);
                scale.setY(1);
                rotate.setAngle(0);
            } else {
                // align c1 and target1
                translate.setX(target1.getCenterX() - c1.getCenterX());
                translate.setY(target1.getCenterY() - c1.getCenterY());

                // scale
                double scaleFactor = Math.hypot(target1.getCenterX() - target2.getCenterX(), target1.getCenterY() - target2.getCenterY())
                        / Math.hypot(c1.getCenterX() - c2.getCenterX(), c1.getCenterY() - c2.getCenterY());
                scale.setPivotX(target1.getCenterX());
                scale.setPivotY(target1.getCenterY());
                scale.setX(scaleFactor);
                scale.setY(scaleFactor);

                // rotate
                rotate.setPivotX(target1.getCenterX());
                rotate.setPivotY(target1.getCenterY());
                rotate.setAngle(Math.toDegrees(Math.atan2(target2.getCenterY() - target1.getCenterY(), target2.getCenterX() - target1.getCenterX())
                        - Math.atan2(c2.getCenterY() - c1.getCenterY(), c2.getCenterX() - c1.getCenterX())));

            }
            transformed = !transformed;
        }
    });
    primaryStage.setScene(scene);
    primaryStage.show();

}