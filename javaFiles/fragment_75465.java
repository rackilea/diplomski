Button btn1 , btn2 , btn3;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    btn1 = findViewById(R.id.button1);
    btn2 = findViewById(R.id.button2);
    btn3 = findViewById(R.id.button3);


    btn1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this,Main2Activity.class);
            String str = btn1.getText().toString();
            intent.putExtra("text",str);
            startActivity(intent);
        }
    });

    btn2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this,Main2Activity.class);
            String str = btn2.getText().toString();
            intent.putExtra("text",str);
            startActivity(intent);
        }
    });
    btn3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this,Main2Activity.class);
            String str = btn3.getText().toString();
            intent.putExtra("text",str);
            startActivity(intent);

        }
    });
}