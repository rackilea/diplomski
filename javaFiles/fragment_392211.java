public class MainActivity extends AppCompatActivity {

    Button mConvert;
    DBHelper mDBHlpr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Need to have permission to External Storage
        if(Build.VERSION.SDK_INT >= 23) {
            ExternalStoragePermissions.verifyStoragePermissions(this);
        }

        mConvert = this.findViewById(R.id.convert_table);
        mConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crtCSV(DBHelper.TB_TEST1 + String.valueOf(System.currentTimeMillis()),DBHelper.TB_TEST1);
            }
        });
        mDBHlpr = new DBHelper(this);
        mDBHlpr.addTest1Row("Fred","Fred@email.com");
        mDBHlpr.addTest1Row("Mary","mary@email.com");
    }

    private int crtCSV(String filename, String table) {
        if(!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            return -1;
        }
        File dir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),"mycsvfiles");
        String directory = dir.getPath();
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File f = new File(directory,filename);
        try {
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            return -2;
        }
        f.delete();

        FileOutputStream fo;
        try {
            fo = new FileOutputStream(f);
        } catch (IOException e) {
            e.printStackTrace();
            return -3;
        }
        Cursor csr = mDBHlpr.getCSVRows(table);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fo));
        try {
            bw.write(mDBHlpr.getColumnsAsCSV(table));
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            try {
                fo.close();
            } catch (IOException e1) {
                e1.printStackTrace();
                f.delete();
                return -4;
            }
            f.delete();
            return -5;
        }
        while (csr.moveToNext()) {
            String line = csr.getString(0);
            try {
                bw.write(line);
                bw.newLine();
            } catch (IOException e) {
                e.printStackTrace();
                try {
                    fo.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                    f.delete();
                    return -6;
                }
                f.delete();
                return -7;
            }
        }
        csr.close();
        try {
            bw.close();
            fo.flush();
            fo.close();
        } catch (IOException e) {
            e.printStackTrace();
            return -8;
        }
        return 0;
    }
}