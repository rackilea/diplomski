private void getVideo(){
    final JFXPanel VFXPanel = new JFXPanel();

    File video_source = new File("tutorial.mp4");
    Media m = new Media(video_source.toURI().toString());
    MediaPlayer player = new MediaPlayer(m);
    MediaView viewer = new MediaView(player);

    StackPane root = new StackPane();
    Scene scene = new Scene(root);

    // center video position
    javafx.geometry.Rectangle2D screen = Screen.getPrimary().getVisualBounds();
    viewer.setX((screen.getWidth() - videoPanel.getWidth()) / 2);
    viewer.setY((screen.getHeight() - videoPanel.getHeight()) / 2);

    // resize video based on screen size
    DoubleProperty width = viewer.fitWidthProperty();
    DoubleProperty height = viewer.fitHeightProperty();
    width.bind(Bindings.selectDouble(viewer.sceneProperty(), "width"));
    height.bind(Bindings.selectDouble(viewer.sceneProperty(), "height"));
    viewer.setPreserveRatio(true);

    // add video to stackpane
    root.getChildren().add(viewer);

    VFXPanel.setScene(scene);
    //player.play();
    videoPanel.setLayout(new BorderLayout());
    videoPanel.add(VFXPanel, BorderLayout.CENTER);
}