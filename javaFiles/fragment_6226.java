@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    loadWorld("World.tmx");  //<< here

    setContentView(R.layout.activity_main);
}