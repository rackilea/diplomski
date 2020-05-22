private int btnSize = 0;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    // Other codes here...
    btnSize = (int) this.getResources().getDimension(R.dimen.box_size);
}