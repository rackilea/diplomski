@Override
protected void onCreate(Bundle savedInstanceState) {
    Intent intent = getIntent();
    if (intent.hasExtra("result")) {
        // Launched from search results
        Serializable selectedResult = (Serializable) intent.getSerializableExtra("result");
        ...
    }
    ...
}