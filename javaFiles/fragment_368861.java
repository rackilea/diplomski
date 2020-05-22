private SharedPreferences mSharedPreferences;
private Editor mEditor;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_a);

    mSharedPreferences = getSharedPreferences("yourPrefsFileName", Context.MODE_PRIVATE));
    mEditor = mSharedPreferences.edit();

    if (mSharedPreferences.getBoolean("isfirstTime", true)) {
        mEditor.putBoolean("isFirstTime",false);
        mEditor.apply();
    }else{
         startActivity(new Intent(this, ActivityB.class));
         overridePendingTransition(0, 0);
         finish();
      }
}