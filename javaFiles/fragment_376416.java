private String[] myString;
public static final Random rgenerator = new Random();

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.study);

    Resources res = getResources();

    myString = res.getStringArray(R.array.list);

    String q = myString[rgenerator.nextInt(myString.length)];

    TextView word = (TextView) findViewById(R.id.word);
    word.setText(q);

}

public void onSaveInstanceState(Bundle savedInstanceState) {

    TextView wordTextView = (TextView)findViewById(R.id.word);
    String wordText = wordTextView.getText().toString();

    savedInstanceState.putString("wordText", wordText);
    super.onSaveInstanceState(savedInstanceState);
}

@Override
public void onRestoreInstanceState(Bundle savedInstanceState) {
  super.onRestoreInstanceState(savedInstanceState);

  TextView wordTextView = (TextView)findViewById(R.id.word);

  String wordText = savedInstanceState.getString("wordText");
  wordTextView.setText(wordText);
}