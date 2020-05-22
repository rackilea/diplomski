public class FileIO extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        DBHelper db = new DBHelper(this);

        try { 
            copyFile();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            Log.i("Main", "Complete");
            db.close();
            finish();
        }
    }

    public void copyFile() throws IOException {
        File data = Environment.getDataDirectory();
        String state = Environment.getExternalStorageState();

        /* Create file first
            FileOutputStream created = openFileOutput("copyFile.db", MODE_WORLD_READABLE);
            created.close();
        */

        String currentDBPath = "/data/<your_path>/databases/data.db";
        String backupDBPath = "/data/<your_path>/databases/copyByFile.db";
        File currentDB = new File(data, currentDBPath);
        File backupDB = new File(data, backupDBPath);

        if (currentDB.exists()) {
            FileChannel src = new FileInputStream(currentDB).getChannel();
            FileChannel dst = new FileOutputStream(backupDB).getChannel();
            dst.transferFrom(src, 0, src.size());
            src.close();
            dst.close();
        }
        else
            Log.i("Main", "Current db does not exist");
    }
}