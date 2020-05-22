....

EditText enternumberofdice;
TextView textGenerateNumber;
private EditText text, text2, text3;
private Button btutorial1;
int number1;
int number2;
ImageView i;
private int myFaceValue;
int myNum;


@Override
public void onCreate(Bundle savedInstanceState) 
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    textGenerateNumber = (TextView) findViewById(R.id.text4);

    //BUG: will fail since text/text2 isn't initialized
    //number1 = Integer.parseInt(text.getText().toString());
    //number2 = Integer.parseInt(text2.getText().toString());

    i = new ImageView(this);
    i.setAdjustViewBounds(true);
}