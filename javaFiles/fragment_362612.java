@Override
public void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    TextView yourTextview = (TextView)findViewById(R.id.yourTextviewId);
    EditText yourEditText = (EditText)findViewById(R.id.yourTextviewId);
    Buton yourOkButton = (Button)findViewById(R.id.yourOkButtonId);

    yourOkButton.setOnClickListener(
        new View.OnClickListener()
        {
            public void onClick(View view)
            {
                yourTextview.setText(yourEditText.getText().toString());
            }
        });
}