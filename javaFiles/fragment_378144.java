public class AdminAreaActivity extends AppCompatActivity {
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String RESTAURANT_NAME = "restaurantName";

    private EditText etDRestaurantName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_area);

        etDRestaurantName = findViewById(R.id.etRestaurantName);
        final Button bRestaurantChange = findViewById(R.id.bRestaurantChange);

        bRestaurantChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!etDRestaurantName.getText().toString().matches("")) {
                    Intent mainIntent = new Intent(AdminAreaActivity.this, MainActivity.class);
                    saveData(RESTAURANT_NAME, etDRestaurantName.getText().toString() + "!");
                    etDRestaurantName.getText().clear();
                    startActivity(mainIntent);
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(AdminAreaActivity.this);
                    builder.setMessage("Failed!").setNegativeButton("Retry", null).create().show();
                }
            }
        });

    }

    public void saveData(String prefName, String prefValue) {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(prefName, prefValue);
        editor.apply();
        Toast.makeText(this, "Data saved!", Toast.LENGTH_SHORT);

    }
}