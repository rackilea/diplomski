Public class MainActivity extends Activity implements View.OnClickListener {

private LinearLayout lnrImages;
private Button btnAddPhots;
private Button btnSaveImages;
private ArrayList<String> imagesPathList;
private Bitmap yourbitmap;
private Bitmap resized;
private final int PICK_IMAGE_MULTIPLE = 1;
static final String FTP_HOST = "";
static final String FTP_USER = "";
static final String FTP_PASS = "";
String j;
Uri uri;    
String str;
String picturepath, currentpath;
Button b;
String r;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    if (android.os.Build.VERSION.SDK_INT > 9) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }
    lnrImages = (LinearLayout) findViewById(R.id.lnrImages);
    btnAddPhots = (Button) findViewById(R.id.btnAddPhots);
    btnSaveImages = (Button) findViewById(R.id.btnSaveImages);
    b = (Button) findViewById(R.id.btnSaveImages1);
    btnAddPhots.setOnClickListener(this);
    btnSaveImages.setOnClickListener(this);
}

@Override
public void onClick(View view) {
    switch (view.getId()) {
    case R.id.btnAddPhots:
        Intent intent = new Intent(MainActivity.this,
                CustomPhotoGalleryActivity.class);
        startActivityForResult(intent, PICK_IMAGE_MULTIPLE);
        break;
    case R.id.btnSaveImages: