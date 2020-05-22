public class MyActivity extends Activity implements MyAdapterInterface {

    private CustomCursorAdapter customAdapter;
    public ListView list1;

    com.example.rory.dbtest.DBAdapter db = new com.example.rory.dbtest.DBAdapter(this);

    public EditText TotalCost;
    //public EditText TotalLitres;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        list1 = (ListView)findViewById(R.id.data_list);
        db.open();


        Button addBtn = (Button)findViewById(R.id.add);
        addBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(MyActivity.this, addassignment.class);
                startActivity(i);
            }
        });

        Button deleteBtn = (Button)findViewById(R.id.delete);
        deleteBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(MyActivity.this, Delete.class);
                startActivity(i);
            }
        });

        Button updateBtn = (Button)findViewById(R.id.update);
        updateBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(MyActivity.this, Update.class);
                startActivity(i);
            }
        });


        try {
            String destPath = "/data/data/" + getPackageName() + "/databases/AssignmentDB";
            File f = new File(destPath);
            if (!f.exists()) {
                CopyDB( getBaseContext().getAssets().open("mydb"),
                        new FileOutputStream(destPath));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


       new Handler().post(new Runnable() {
            @Override
            public void run() {
                //Log.d("test", "customadapter is " + customAdapter.toString());
                //Log.d("test", "databaseHelper is " + databaseHelper.toString());
                customAdapter = new CustomCursorAdapter(MyActivity.this, db.getAllRecords(), this);
                list1.setAdapter(customAdapter);
            }
        });

        @Override
            public void updateEditText(String value) {
                EditText myEditText = (EditText)findViewById(R.id./*YOUR EDITTEXT ID*/);
                myEditText.setText(value);
        }
    }

    private class DBAdapter extends BaseAdapter {
        private LayoutInflater mInflater;
        //private ArrayList<>

        @Override
        public int getCount() {

            return 0;
    }

        @Override
        public Object getItem(int arg0) {

            return null;
        }

        @Override
        public long getItemId(int arg0) {

            return 0;
        }

        @Override
        public View getView(int arg0, View arg1, ViewGroup arg2) {

            return null;
        }

    }

    public void CopyDB(InputStream inputStream, OutputStream outputStream)
            throws IOException {
        //---copy 1K bytes at a time---
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, length);
        }
        inputStream.close();
        outputStream.close();
    }
}