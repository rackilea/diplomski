@Override
public void start(Stage primaryStage) {
    Group root1 = new Group();
    Group root2 = new Group();

    Scene scene1 = new Scene(root1, 300, 250);
    Scene scene2 = new Scene(root2, 300, 250);

    Rectangle rectangle2 = new Rectangle(300, 250);
    rectangle2.setFill(Color.BLUE);
    root2.getChildren().add(rectangle2);

    Rectangle rectangle1 = new Rectangle(300, 250);
    rectangle1.setFill(Color.RED);
    root1.getChildren().add(rectangle1);

    primaryStage.setTitle("Hello World!");
    primaryStage.setScene(scene1);
    primaryStage.show();

    rectangle1.setOnMouseClicked(e->{
        // Create snapshots with the last state of the scenes
        WritableImage wi = new WritableImage(300, 250);
        Image img1 = root1.snapshot(new SnapshotParameters(),wi);
        ImageView imgView1= new ImageView(img1);
        wi = new WritableImage(300, 250);
        Image img2 = root2.snapshot(new SnapshotParameters(),wi);
        ImageView imgView2= new ImageView(img2);
        // Create new pane with both images
        imgView1.setTranslateX(0);
        imgView2.setTranslateX(300);
        StackPane pane= new StackPane(imgView1,imgView2);
        pane.setPrefSize(300,250);
        // Replace root1 with new pane
        root1.getChildren().setAll(pane);
        // create transtition
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(imgView2.translateXProperty(), 0, Interpolator.EASE_BOTH);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t->{
            // remove pane and restore scene 1
            root1.getChildren().setAll(rectangle1);
            // set scene 2
            primaryStage.setScene(scene2);
        });
        timeline.play();
    });
    rectangle2.setOnMouseClicked(e->{
        // Create snapshots with the last state of the scenes
        WritableImage wi = new WritableImage(300, 250);
        Image img1 = root1.snapshot(new SnapshotParameters(),wi);
        ImageView imgView1= new ImageView(img1);
        wi = new WritableImage(300, 250);
        Image img2 = root2.snapshot(new SnapshotParameters(),wi);
        ImageView imgView2= new ImageView(img2);
        // Create new pane with both images
        imgView2.setTranslateX(0);
        imgView1.setTranslateX(300);
        StackPane pane= new StackPane(imgView2,imgView1);
        pane.setPrefSize(300,250);
        // Replace root2 with new pane
        root2.getChildren().setAll(pane);
        // create transtition
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(imgView1.translateXProperty(), 0, Interpolator.EASE_BOTH);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t->{
            // remove pane and restore scene 2
            root2.getChildren().setAll(rectangle2);
            // set scene 1
            primaryStage.setScene(scene1);
        });
        timeline.play();
    });

}