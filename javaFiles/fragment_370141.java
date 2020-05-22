EditText numberone;
EditText numbertwo;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    numberone = (EditText)findViewById(R.id.number1);
    numbertwo = (EditText)findViewById(R.id.number2);

}