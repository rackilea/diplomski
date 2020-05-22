public class savepdf extends ActionBarActivity {
    static final int REQUEST_IMAGE_OPEN = 1;
    private static final int WRITE_REQUEST_CODE = 43;
    private Uri mData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savepdf);

        // Get intent, action and MIME type
        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();

        if (Intent.ACTION_SEND.equals(action) && type != null) {
            if ("application/pdf".equals(type)) {
                handlePDF(intent);
            }
        } else if (Intent.ACTION_SEND_MULTIPLE.equals(action) && type != null) {
            if (type.startsWith("application/pdf")) {
                // Handle multiple pdfs being sent
            }
        } else {
            // Handle other intents, such as being started from the home screen
        }
    }

    void handlePDF(Intent intent) {
        Uri pdfUri = (Uri) intent.getParcelableExtra(Intent.EXTRA_STREAM);
        if (pdfUri != null) {
            //savefile(pdfUri);

            String sourceFilename= pdfUri.getPath();
            String destinationFilename = android.os.Environment.getExternalStorageDirectory().getPath()+File.separatorChar+"abc.pdf";

            BufferedInputStream bis = null;
            BufferedOutputStream bos = null;

            try {
                bis = new BufferedInputStream(new FileInputStream(sourceFilename));
                bos = new BufferedOutputStream(new FileOutputStream(destinationFilename, false));
                byte[] buf = new byte[1024];
                bis.read(buf);
                do {
                    bos.write(buf);
                } while(bis.read(buf) != -1);
            } catch (IOException e) {

            } finally {
                try {
                    if (bis != null) bis.close();
                    if (bos != null) bos.close();
                } catch (IOException e) {

                }
            }















            // TODO: Use your server-side here to save.

        }







       }