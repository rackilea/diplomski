@Override
protected void onCreate(Bundle savedInstanceState) {
    BitmapDrawable ob = new BitmapDrawable(getResources(),MyApplication.back2);
    getWindow().getDecorView().setBackground(ob);
    super.onCreate(savedInstanceState);
    setContentView(R.layout.filter_activity);
}