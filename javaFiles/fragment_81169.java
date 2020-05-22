public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnred,btngreen,btnblue,btnpluse,btnsave;
    private LinearLayout mlinearLayout;
    private TextView tv;
    int point = 0;
    public SharedPreferences sp,prefs;
    private int progress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences prefs = getSharedPreferences("save", MODE_PRIVATE);
        String textValue= prefs.getString("textValue", "0");

        mlinearLayout=(LinearLayout)findViewById(R.id.activity_main);
        SharedPreferences sp = getSharedPreferences("saveColour", MODE_PRIVATE);
        int colourValue = sp.getInt("colourValue", Color.WHITE);
        mlinearLayout.setBackgroundColor(colourValue);

        btnred = (Button) findViewById(R.id.cred);
        btnblue = (Button) findViewById(R.id.cblue);
        btngreen = (Button) findViewById(R.id.cgreen);
        btnpluse = (Button)findViewById(R.id.btnadd);
        btnsave = (Button)findViewById(R.id.save);
        tv=(TextView)findViewById(R.id.tv) ;
        tv.setText(textValue);
        btnred.setOnClickListener(this);
        btnsave.setOnClickListener(this);
        btnpluse.setOnClickListener(this);
        btnblue.setOnClickListener(this);
        btngreen.setOnClickListener(this);


        }



    @Override
    public void onClick(View v) {
        if (btnred == v){
            mlinearLayout.setBackgroundColor(Color.RED);
            SharedPreferences.Editor editor = getSharedPreferences("saveColour", MODE_PRIVATE).edit();
            editor.putInt("colourValue", Color.RED);
            editor.commit();

        }
        else if (btngreen == v){
            mlinearLayout.setBackgroundColor(Color.GREEN);
            SharedPreferences.Editor editor = getSharedPreferences("saveColour", MODE_PRIVATE).edit();
            editor.putInt("colourValue", Color.GREEN);
            editor.commit();
        }
        else if (btnblue == v){
            mlinearLayout.setBackgroundColor(Color.BLUE);
            SharedPreferences.Editor editor = getSharedPreferences("saveColour", MODE_PRIVATE).edit();
            editor.putInt("colourValue", Color.BLUE);
            editor.commit();


        }
        else if (btnpluse== v){
            point++;
            tv.setText("" + point);

        }
        else if (btnsave == v){
            Toast.makeText(this,"btn clickd",Toast.LENGTH_LONG).show();
            SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE).edit();
            editor.putString("textValue", tv.getText().toString());
            editor.commit();
        }
    }
}