@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Firebase.setAndroidContext(this);
    Firebase.getDefaultConfig().setPersistenceEnabled(true);
    Firebase.getDefaultConfig().setLogLevel(Logger.Level.DEBUG);
    Firebase ref = new Firebase("https://stackoverflow.firebaseio.com/30987733");
    Map<String, Object> children = new HashMap<>();
    children.put("updated_at", new Date().toString());
    children.put("is_handled", true);
    ref.updateChildren(children);
}