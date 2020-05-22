int i = 0;
String[] myList={"one", "two", "three", "four", "five"};
TextView textDisplay;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_aba);

    textDisplay = (TextView) findViewById(R.id.textDisplay);
}

public void forwardButton(View view)  {
    if(i < myList.length - 1) {
        i++;
        textDisplay.setText(myList[i]);
    }

}

public void backButton(View view)  {
    if(i > 0) {
        i--;
        textDisplay.setText(myList[i]);
    }
}