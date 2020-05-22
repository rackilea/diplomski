public class PrefDemoActivity extends AppCompatActivity {

@Override
protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    FragmentManager mFragmentManager = getFragmentManager();
    FragmentTransaction mFragmentTransaction = mFragmentManager
            .beginTransaction();
    DemoEditPreferences mDemoPrefsFragment = new DemoEditPreferences();
    mFragmentTransaction.replace(android.R.id.content, mDemoPrefsFragment);
    mFragmentTransaction.commit();

}
}