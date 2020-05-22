public class highscores extends Activity {     
    private ListView scorebox;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.highscores);
    DBHandler db = new DBHandler(this);
    scorebox = (ListView) findViewById(R.id.scorebox);
    Log.d("Insert: ", "Inserting ..");
    db.addScore(9000);
    Log.d("Reading: ", "Reading all contacts..");
    ArrayList<String>ar=new ArrayList<>();
    ar=db.getAllScores();
    ArrayAdapter<String>ar=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,s);
    scorebox.setAdapter(ar);
}
}