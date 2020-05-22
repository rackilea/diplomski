public class MainActivity extends AppCompatActivity {

    private CardView cardview;
    private CardView cardview2;
    private LinearLayout.LayoutParams layoutparams1;
    private LinearLayout layout;
    public SharedPreferences mSettings;
    int mCount;
    int i=0,j=0;
    public TextView tv1;
    public TextView tv4;
    public TextView tv3;
    String name;
    String names[] = new String[10];
    String key[] = {"A","B","C","D","F","G","H"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCount=0;

        Button b1 = findViewById(R.id.button);
        layout=findViewById(R.id.view);
        tv1 = findViewById(R.id.textView);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                names[mCount] = tv1.getText().toString().trim();
                mCount++;
                saveName();
            }
        });
    }

    private void saveName()    //Cardview-1 function to
    {
        cardview = new CardView(getApplicationContext());
        layoutparams1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutparams1.setMargins(18, 30, 18, 0);
        cardview.setLayoutParams(layoutparams1);
        cardview.setCardBackgroundColor(Color.WHITE);
        cardview.setMinimumHeight(400);

        tv3 = new TextView(getApplicationContext());
        tv3.setText(tv1.getText().toString().trim());

        cardview.setRadius(30);
        cardview.addView(tv3);
        layout.addView(cardview);

        saveInPref();
    }

    private void saveInPref() {
        mSettings = getSharedPreferences("APP_PREFERENCES", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putInt("COUNT_CARDS", mCount);
        editor.putString(key[mCount-1],names[mCount-1]);
        editor.apply();
    }

    private void saveName2()  //Cardview 2 function
    {
        cardview2 = new CardView(getApplicationContext());
        layoutparams1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutparams1.setMargins(18, 30, 18, 0);
        cardview2.setLayoutParams(layoutparams1);
        cardview2.setCardBackgroundColor(Color.WHITE);
        cardview2.setMinimumHeight(400);
        tv4 = new TextView(getApplicationContext());

        mSettings = getSharedPreferences("APP_PREFERENCES", Context.MODE_PRIVATE);
        name = mSettings.getString(key[j],"");
        tv4.setText(name);
        j++;

        cardview2.setRadius(30);
        cardview2.addView(tv4);
        layout.addView(cardview2);
    }


    @Override
    public void onResume() {
        super.onResume();
        mSettings = getSharedPreferences("APP_PREFERENCES", Context.MODE_PRIVATE);
        if(mSettings.contains("COUNT_CARDS"))
        {
            mCount = mSettings.getInt("COUNT_CARDS", 0);
            for (int i=0; i<mCount; i++)
                saveName2();
        }
    }
}