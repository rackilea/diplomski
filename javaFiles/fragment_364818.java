@Override
public void start(Stage primaryStage) throws Exception {
    PerspectiveCamera camera = new PerspectiveCamera(true);
    camera.setTranslateZ(-20);
    Group sceneRoot = new Group();
    Scene scene = new Scene(sceneRoot, 800, 600, true, SceneAntialiasing.BALANCED);
    scene.setCamera(camera);
    Group group = new Group();

    for (int i = -5; i < 5; i++) {
        for (int j = -2; j < 2; j++) {
            for (int k = 0; k < 3; k++) {
                SegmentedSphereMesh sphere = new SegmentedSphereMesh(50, 0, 0, 0.75, new Point3D((float) i, (float) j, (float) k)); 

                sphere.setTextureModeNone(Color.rgb(255 / 10 * (6 + i), 255 / 5 * (j + 3), 255 / 3 * (k + 1)));
                group.getChildren().add(sphere);
            }
        }
    }

    group.getTransforms().addAll(new Rotate(40, Rotate.X_AXIS), new Rotate(10, Rotate.Y_AXIS));
    sceneRoot.getChildren().addAll(group);        

    primaryStage.setTitle("F(X)yz - Segmented Spheres Group");
    primaryStage.setScene(scene);
    primaryStage.show();   

    GroupOBJWriter writer=new GroupOBJWriter(group,"spheres");
    writer.exportMesh();
}