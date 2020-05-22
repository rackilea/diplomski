private SurfacePlotMesh surface;
private long lastEffect;

@Override
public void start(Stage primaryStage) {
    PerspectiveCamera camera = new PerspectiveCamera(true);   
    camera.setTranslateZ(-30);
    surface = new SurfacePlotMesh(
            p-> Math.sin(p.magnitude() + 1e-10) / (p.magnitude() + 1e-10), 
            20, 20, 100, 100, 4); 
    surface.setCullFace(CullFace.NONE);
    surface.setTextureModeVertices3D(1530, p -> p.magnitude());
    surface.getTransforms().addAll(new Rotate(200, Rotate.X_AXIS), new Rotate(-20, Rotate.Y_AXIS));

    final Group group = new Group(surface);
    Scene scene = new Scene(group, 600, 400, true, SceneAntialiasing.BALANCED);
    scene.setCamera(camera);

    primaryStage.setScene(scene);
    primaryStage.show(); 

    lastEffect = System.nanoTime();
    AtomicInteger count=new AtomicInteger();
    AnimationTimer timerEffect = new AnimationTimer() {

        @Override
        public void handle(long now) {
            if (now > lastEffect + 1_000_000_000l) {
                double t = (count.get() % 5 + 1);
                surface.setFunction2D(p -> Math.sin(t * p.magnitude() + 1e-10)/(t * p.magnitude() + 1e-10));
                count.getAndIncrement();
                lastEffect = now;
            }
        }
    };
    timerEffect.start();
}