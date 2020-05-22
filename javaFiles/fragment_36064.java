public class MainActivity extends AppCompatActivity {
    private static MainActivity instance;

    public static MainActivity getInstance() {
        Log.i("MainActivity", "getInstance");
        return instance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instance of the MainActivity
        instance = this;
    }
    ...

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    Log.i(TAG, "onActivityResult");
    switch (requestCode) {
        // Check for the integer request code originally supplied to startResolutionForResult().
        case REQUEST_CHECK_SETTINGS:
            switch (resultCode) {
                case Activity.RESULT_OK:
                    Log.i(TAG, "User agreed to make required location settings changes.");
                    startService(intent);
                    break;
                case Activity.RESULT_CANCELED:
                    Log.i(TAG, "User chose not to make required location settings changes.");
                    break;
            }
            break;
        }
    }
}