@Override
public void onCreate(@Nullable Bundle savedInstanceState, @Nullable 
PersistableBundle persistentState) {
    super.onCreate(savedInstanceState, persistentState);
    setContentView(R.layout.default_pref);

    getFragmentManager().beginTransaction().replace(R.id.rep, new 
PrefFrag()).commit();
}