public class MainActivity extends AppCompatActivity implements View.OnClickListener {

private Button button_sbm;
private TextView myTextview;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    button_sbm = (Button) findViewById(R.id.start);
    myTextview = (TextView) findViewById(R.id.textview99);

    Typeface myTypeFace = Typeface.createFromAsset(getAssets(), "font.ttf");
    myTextview.setTypeface(myTypeFace);
    button_sbm.setOnClickListener(this);
}

@Override
public void onClick(View view) {
    Toast.makeText(getApplicationContext(), "Click is Working", Toast.LENGTH_LONG).show();
    Intent intent = new Intent("com.example.android.yes.FirstActivity");
    startActivity(intent);
  }
}