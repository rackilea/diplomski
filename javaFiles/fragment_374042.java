@Override
public void start(Stage primaryStage) {
    Sphere sphere = new Sphere(100);
    sphere.setMaterial(new PhongMaterial(Color.BLUE));
    Box box = new Box(50,50,50);
    box.setMaterial(new PhongMaterial(Color.RED));
    box.setTranslateX(300);
    Cylinder cylinder = new Cylinder(2, 300);
    cylinder.setMaterial(new PhongMaterial(Color.GREEN));
    // Transformations applied:
    cylinder.getTransforms().addAll(new Translate(150, 0, 0), new Rotate(90, Rotate.Z_AXIS));

    Group group = new Group(cylinder, sphere, box);
    StackPane root = new StackPane(group);

    Scene scene = new Scene(root, 600, 400);

    primaryStage.setScene(scene);
    primaryStage.show();

    // export as single mesh
    EquivalentMesh equivalentMesh = new EquivalentMesh(root);
    equivalentMesh.export("group");
}