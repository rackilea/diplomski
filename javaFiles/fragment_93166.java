public class defaultPref extends PreferenceActivity {
    @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.default_pref);

        getFragmentManager().beginTransaction().replace(R.id.rep, new 
        PrefFrag()).commit();
        }

public static class PrefFrag extends PreferenceFragment{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preference);
    }
  }
}