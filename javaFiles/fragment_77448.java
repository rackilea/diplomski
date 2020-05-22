public class FaecherActivity extends AppCompatActivity{

EditText et_facheintrag;
EditText et_raumeintrag;
EditText et_farbeintrag;
ListView lv_faecher;
MyDBHandlerFaecher dbHandlerFaecher;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_faecher);

    et_facheintrag = (EditText) findViewById(R.id.et_facheintrag);
    et_raumeintrag = (EditText) findViewById(R.id.et_raumeintrag);
    et_farbeintrag = (EditText) findViewById(R.id.et_farbeintrag);
    lv_faecher = (ListView) findViewById(R.id.lv_faecher);
    dbHandlerFaecher = new MyDBHandlerFaecher(this, null, null, 1);

    printDatabase();
}

//Add fach to database
public void addButtonClicked(View view){
    Faecher fach = new Faecher(et_facheintrag.getText().toString(), et_raumeintrag.getText().toString(),
                                et_farbeintrag.getText().toString());
    dbHandlerFaecher.addFach(fach);
    printDatabase();
}

public void deleteButtonClicked(View view){
    String inputText = et_facheintrag.getText().toString();
    dbHandlerFaecher.deleteFach(inputText);
    printDatabase();
}

public void printDatabase(){
    String[] fromColumns = dbHandlerFaecher.databaseToStringArray();
    int[] toViews = new int[]{R.id.facheintrag, R.id.raumeintrag, R.id.farbeintrag};

    Cursor cursor;
    cursor = dbHandlerFaecher.getWritableDatabase().rawQuery(" SELECT * FROM " + MyDBHandlerFaecher.TABLE_FAECHER + " WHERE 1 ", null);
    //check if cursor is empty
    if (cursor != null && cursor.getCount()>0) {
        Log.d("Event", "Records do exist2");
    }
    else {
        Log.d("Event", "Records do not exist2");
    }
    SimpleCursorAdapter fachadapter = new FaecherRowAdapter(this, R.layout.faecher_row, cursor, fromColumns,toViews, 0);
    lv_faecher.setAdapter(fachadapter);