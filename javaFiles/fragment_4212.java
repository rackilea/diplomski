@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_edited);

    String name;
    name = getIntent().getStringExtra("theName");

    EditText editList = (EditText) findViewById(R.id.editText);
    editList.setText(name);

    Button addBtn = (Button) findViewById(R.id.add_btn);
    addBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            saveListInfo();
        }
    });
}