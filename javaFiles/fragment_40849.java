public class SettingsActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    Bundle bundle = new Bundle();
    bundleSettings.putString("my_bundle_key", "Bundle");     
    SettingsFragment settingsFragment = new SettingsFragment();
    settingsFragment.setArguments(bundle);

    getSupportFragmentManager().beginTransaction()
            .replace(android.R.id.content, settingsFragment )
            .commit();