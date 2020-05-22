public class Window3DBuilder {

    private final Group group;
    private SurfacePlotMesh surface;
    private final CameraTransformer cameraTransformer;
    private final PerspectiveCamera perspectiveCamera;
    private PointLight light;

    public Window3DBuilder( Group group, PerspectiveCamera perspectiveCamera ) {
        this.group = group;
        this.perspectiveCamera = perspectiveCamera;
        cameraTransformer = new CameraTransformer();
    }

    public void createScene() {
        createSurface();
        group.getChildren().addAll(surface, cameraTransformer);

        cameraTransformer.setTranslate(0, 0, 0);
        cameraTransformer.getChildren().addAll(perspectiveCamera);

        perspectiveCamera.setNearClip(0.1);
        perspectiveCamera.setFarClip(100000.0);
        perspectiveCamera.setTranslateX((group.getBoundsInLocal().getMaxX() + group.getBoundsInLocal().getMinX()) / 2d);
        perspectiveCamera.setTranslateY((group.getBoundsInLocal().getMaxY() + group.getBoundsInLocal().getMinY()) / 2d);
        double max = Math.max(group.getBoundsInLocal().getWidth(), group.getBoundsInLocal().getHeight());
        perspectiveCamera.setTranslateZ(-2 * max);
        createLight();
    }

    public void createLight() {
        light = new PointLight(Color.WHITE);
        cameraTransformer.getChildren().add(light);
        light.setTranslateX(perspectiveCamera.getTranslateX());
        light.setTranslateY(perspectiveCamera.getTranslateY());
        light.setTranslateZ(perspectiveCamera.getTranslateZ() / 10);
    }

    private void createSurface() {
        surface = new SurfacePlotMesh(
                p-> Math.sin(p.magnitude() + 1e-10) / (p.magnitude() + 1e-10),
                20, 20, 100, 100, 4);
        surface.setCullFace(CullFace.NONE);
        surface.setTextureModeVertices3D(1530, p -> p.magnitude());
        surface.getTransforms().addAll(new Rotate(200, Rotate.X_AXIS), new Rotate(-20, Rotate.Y_AXIS));
    }

}