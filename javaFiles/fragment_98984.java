@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ArrayList<Note> notes = new ArrayList<Note>();
    try {
        notes.add(new Note(System.currentTimeMillis(), "Note 1"));
        Thread.sleep(2);
        notes.add(new Note(System.currentTimeMillis(), "Note 2"));
        Thread.sleep(2);
        notes.add(new Note(System.currentTimeMillis(), "Note 3"));
    } catch (Exception e) {

    }
    SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);

    SharedPreferences.Editor edit = sp.edit();

    for (Note n : notes) {
        edit.putString(n.getKeyAsString(), n.getNote());
    }
}