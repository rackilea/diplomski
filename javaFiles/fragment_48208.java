@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    LinearLayout layout = new      LinearLayout(this.getApplicationContext());
    String[] channels = {"a", "b", "c"};

    for (int i = 0; i < channels.length; i++) {
        TextView iteratorView = new TextView(this);
        iteratorView.setText(channels[i]);
        layout.addView(iteratorView);
    }
setContentView(layout);
}