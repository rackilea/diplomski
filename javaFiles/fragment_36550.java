public class MainActivity extends ActionBarActivity {

public static Context context;
public static final String DIR_SDCARD =Environment.getExternalStorageDirectory().getAbsolutePath();
public static final String DIR_DATABASE = DIR_SDCARD + "/Mafatih/";
public String Titel_Drawer;
public String messageCursor;
private ListView mainListView ;
public SQLiteDatabase  sql;
public Cursor cursor;
public ArrayList<String> array;
private ArrayAdapter<String> listAdapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        File file= new File(DIR_DATABASE);
        file.mkdirs();
        sql = SQLiteDatabase.openOrCreateDatabase(DIR_DATABASE + "/Resaleh.db", null);
        cursor = sql.rawQuery("SELECT * FROM WebSite_CategoryBack;", null);
        array = new ArrayList<String>();
        while(cursor.moveToNext()){
            Titel_Drawer = cursor.getString(cursor.getColumnIndex("tittle"));
            array.add(Titel_Drawer);
        }
        cursor.close();
        mainListView = (ListView) findViewById( R.id.mainListView );
        listAdapter = new ArrayAdapter<String>(this, R.layout.drawer_layout_main,R.id.rowTextView_Main, array);
        mainListView.setAdapter( listAdapter );
         mainListView.setOnItemClickListener(new OnItemClickListener() {
             @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,long arg3) {
                int itemposition = position;
                String itemvalue = (String) mainListView.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),
                        "Position :"+itemposition+"  ListItem : " +itemvalue , Toast.LENGTH_LONG).show();
            }
        });
         mainListView.setTextFilterEnabled(true);
    }