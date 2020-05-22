public class AndroidLauncher extends AndroidApplication implements SampleApplicationControl{
    private static final String LOGTAG = "FrameMarkers";


    // Our OpenGL view:
    public SampleApplicationGLView mGlView;
    public SampleApplicationSession vuforiaAppSession;
    // Our renderer:
    public FrameMarkerRenderer mRenderer;
    MyGDX gdxRender;
    // The textures we will use for rendering:
    public Vector<Texture> mTextures;
    public RelativeLayout mUILayout;

    public Marker dataSet[];

    public GestureDetector mGestureDetector;


    public LoadingDialogHandler loadingDialogHandler = new LoadingDialogHandler(
        this);

    // Alert Dialog used to display SDK errors
    private AlertDialog mErrorDialog;

    boolean mIsDroidDevice = false;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vuforiaAppSession = new SampleApplicationSession(this);
        vuforiaAppSession.setmActivity(this);
        AndroidApplicationConfiguration config = new      AndroidApplicationConfiguration();


        // Load any sample specific textures:
        mTextures = new Vector<Texture>();
        loadTextures();
        startLoadingAnimation();
        vuforiaAppSession.initAR(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        gdxRender = new MyGDX (vuforiaAppSession);
        gdxRender.setTextures(mTextures);
        initialize(gdxRender, config);

        mGestureDetector = new GestureDetector(this, new GestureListener());

        mIsDroidDevice = android.os.Build.MODEL.toLowerCase().startsWith(
            "droid");    
}