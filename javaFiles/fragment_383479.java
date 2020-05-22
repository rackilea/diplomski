private TextView short_summary;
private String s_summary;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.movie_description);

    Intent intent = getIntent();
    if (null != intent) {
        s_summary = intent.getStringExtra("summary");

    }
    short_summary = (TextView) findViewById(R.id.short_summary);
    short_summary.setText(s_summary);
}