public class MainActivity extends AppCompatActivity {

    private TextView etWelcomeToRestaurant2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView etWelcomeToRestaurant = findViewById(R.id.etWelcomeToRestaurant);
        String messg = "Welcome to,\n";
        etWelcomeToRestaurant.setText(messg);

        etWelcomeToRestaurant2 = findViewById(R.id.etWelcomeToRestaurant2);
        etWelcomeToRestaurant2.setText(loadData(AdminAreaActivity.RESTAURANT_NAME, "Your Restaurant here!"));

    }

    public String loadData(String prefName, String defValue){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        return sharedPreferences.getString(prefName, defValue);
    }
}