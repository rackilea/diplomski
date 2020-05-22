public class FXyzJCSG extends Application {
    private double mousePosX, mousePosY;
    private double mouseOldX, mouseOldY;
    private final Rotate rotateX = new Rotate(-20, Rotate.X_AXIS);
    private final Rotate rotateY = new Rotate(-20, Rotate.Y_AXIS);

    @Override
    public void start(Stage primaryStage) throws IOException {

        FrustumMesh cone = new FrustumMesh(1,0.2,4,2);
        cone.setDrawMode(DrawMode.LINE);
        cone.setTextureModeNone(Color.ROYALBLUE);

        CSG coneCSG = Mesh2CSG.mesh2CSG(cone.getMesh());

        CSG cube = new Cube(2).toCSG().color(Color.RED);
        CSG union = cube.union(coneCSG);

        MeshView unionMesh = union.toJavaFXMesh().getAsMeshViews().get(0);
//        unionMesh.setDrawMode(DrawMode.LINE);
        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.getTransforms().addAll (rotateX, rotateY, new Translate(0, 0, -10));

        Group root3D = new Group(camera,unionMesh);

        SubScene subScene = new SubScene(root3D, 600, 400, true, SceneAntialiasing.BALANCED);
        subScene.setFill(Color.AQUAMARINE);
        subScene.setCamera(camera);

        Scene scene = new Scene(new StackPane(subScene), 600, 400);
        scene.setOnMousePressed(me -> {
            mouseOldX = me.getSceneX();
            mouseOldY = me.getSceneY();
        });
        scene.setOnMouseDragged(me -> {
            mousePosX = me.getSceneX();
            mousePosY = me.getSceneY();
            rotateX.setAngle(rotateX.getAngle()-(mousePosY - mouseOldY));
            rotateY.setAngle(rotateY.getAngle()+(mousePosX - mouseOldX));
            mouseOldX = mousePosX;
            mouseOldY = mousePosY;
        });

        primaryStage.setTitle("FXyz & JCSG - JavaFX 3D");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}