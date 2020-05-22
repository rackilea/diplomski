public class MainActivity extends Activity {
public final static String TAG = "FolderActivity";

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    Button button = (Button) findViewById(R.id.button_folder);

    button.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            try {
                folder();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    });
}

private void folder() throws IOException {
    Log.d(TAG, "folder");
    ContextWrapper cw = new ContextWrapper(getBaseContext());
    Log.d(TAG, "cw = new ContextWrapper");
    File folder = cw.getDir("folder", Context.MODE_PRIVATE);
    Log.d(TAG, "folder = cw.getDir");
    File fileInFolder = new File(folder, "fileInFolder");
    Log.d(TAG, "fileInFolder = new File");
    /*
     * Log.d(TAG, "fileInFolder.getAbsolutePath()" +
     * fileInFolder.getAbsolutePath());
     */

    String string = "Hello world!";

    FileOutputStream outputStream = new FileOutputStream(fileInFolder);
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(outputStream));
    out.write(string);
    out.close();
    Log.d(TAG,
            "fileInFolder.getAbsolutePath()"
                    + fileInFolder.getAbsolutePath());
    String s = fileInFolder.getAbsolutePath();
    try {
        getStringFromFile(s);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public static String getStringFromFile(String filePath) throws Exception {
    File fl = new File(filePath);
    FileInputStream fin = new FileInputStream(fl);
    String ret = convertStreamToString(fin);
    // Make sure you close all streams.
    fin.close();
    return ret;
}

public static String convertStreamToString(InputStream is) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
    StringBuilder sb = new StringBuilder();
    String line = null;
    while ((line = reader.readLine()) != null) {
        sb.append(line).append("\n");
    }
    reader.close();
    return sb.toString();
}}