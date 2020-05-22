public class MyGDX extends ApplicationAdapter  {
    ModelInstance modelInstanceHouse;
    private AnimationController controller;
    Matrix4 lastTransformCube;
    // Constants:
    static private float kLetterScale = 25.0f;
    static private float kLetterTranslate = 25.0f;
    // OpenGL ES 2.0 specific:
    private static final String LOGTAG = "FrameMarkerRenderer";
    private int shaderProgramID = 0;
    private Vector<com.mygdx.robot.Texture> mTextures;
    //SampleApplicationSession vuforiaAppSession;
    PerspectiveCamera cam;
    ModelBuilder modelBuilder;
    Model model;
    ModelInstance instance;
    ModelBatch modelBatch;
    static boolean render;
    public SampleApplicationSession vuforiaAppSession;

    public MyGDX ( SampleApplicationSession vuforiaAppSession){
        super();
        this.vuforiaAppSession = vuforiaAppSession;

    }