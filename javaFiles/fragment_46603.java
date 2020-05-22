Camera camera = null;
Camera.Parameters params = null;
boolean isFlashOn = false;
boolean hasFlash;
ImageButton btnSwitch; //add this



protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.name_of_your_xml_layout_for_activity);//add this
    btnSwitch=(ImageButton)findViewById(R.id.imageButton1);//add this

    hasFlash = getApplicationContext().getPackageManager()
            .hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);...