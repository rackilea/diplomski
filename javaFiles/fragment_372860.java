@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main); // pay attention to this

    Button button = (Button) findViewById(R.id.button); // or else it won't know where to find the button in the layout
    button.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            tartActivity(intent);
        }
    });

}