@Override
protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_scan_barcode);
    // Extract the arguments from the Intent's extras
    boolean utilBool = MyActivityArgs.fromBundle(getIntent().getExtras()).getUtilBool();

}