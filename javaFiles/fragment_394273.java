@Override
  public void onCreate(Bundle savedInstanceState) {
    int i = getIntent().getIntExtra("METHOD_TO_CALL", 999);
    if(i == 1){
      callMethod(i);
    }