protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_second);   

    Bundle bundle = getIntent().getExtras();
    ArrayList<contact> arraylist = bundle.getParcelableArrayList("VAR1");
}