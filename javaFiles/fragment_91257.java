@Override
public void start(Stage primaryStage) {
    PerspectiveCamera camera = new PerspectiveCamera(true);
    camera.setNearClip(0.1);
    camera.setFarClip(10000.0);
    camera.setFieldOfView(90);
    Sphere sphere = new Sphere(1000);
    sphere.setCullFace(CullFace.NONE);
    PhongMaterial material = new PhongMaterial();
    /*
    "SonyCenter 360panorama" by François Reincke - Own work. Made using autostitch (www.autostitch.net).. 
    Licensed under CC BY-SA 3.0 via Wikimedia Commons - http://commons.wikimedia.org/wiki/File:SonyCenter_360panorama.jpg#mediaviewer/File:SonyCenter_360panorama.jpg
    */
    material.setDiffuseMap(new Image(getClass().getResource("SonyCenter_360panorama_reversed.jpg").toExternalForm()));
    sphere.setMaterial(material);

    Group root3D = new Group(camera,sphere,new AmbientLight(Color.WHITE));

    Scene scene = new Scene(root3D, 800, 600, true, SceneAntialiasing.BALANCED);

    scene.setCamera(camera);

    primaryStage.setTitle("PhotoSphere in JavaFX3D");
    primaryStage.setScene(scene);
    primaryStage.show();

    final Timeline rotateTimeline = new Timeline();
    rotateTimeline.setCycleCount(Timeline.INDEFINITE);
    camera.setRotationAxis(Rotate.Y_AXIS);
    final KeyValue kv1 = new KeyValue(camera.rotateProperty(), 360);
    final KeyFrame kf1 = new KeyFrame(Duration.millis(30000), kv1);
    rotateTimeline.getKeyFrames().addAll(kf1);
    rotateTimeline.play();
}