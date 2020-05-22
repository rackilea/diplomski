@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_new_order);

    Intent intent = getIntent();
    floorName = intent.getStringExtra("FloorName");
    tableName = intent.getStringExtra("TableName");
    floorId = intent.getIntExtra("FloorId", 1);
    initViews();
}