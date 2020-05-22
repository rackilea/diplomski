public void method2(View view) {
    Intent intent2 = new Intent(this, display2.class);
    EditText enteredpw = (EditText) findViewById(R.id.line2);
    String pw = enteredpw.getText().toString();
    intent2.putExtra("KEY", pw);
    startActivity(intent2);
}

//display2.java
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_display2);

    Intent intent2 = getIntent();
    String pw = intent2.getStringExtra("KEY");
    findViewById(R.id.pwdisplay).setText(pw);