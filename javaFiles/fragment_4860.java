EditText weightE ;
EditText heightE ;
EditText ageE ;
EditText caloriesresult;
RadioButton male ;
RadioButton female; 
@Override
public void onCreate(Bundle savedInstanceState) 
{
super.onCreate(savedInstanceState); 
setContentView(R.layout.bmilayout_main); // must be first 
weightE = (EditText)findViewById(R.id.weightText); // then initialize your views
heightE = (EditText)findViewById(R.id.heightText);
ageE = (EditText)findViewById(R.id.ageText);
caloriesresult = (EditText)findViewById(R.id.caloriesText);
male = (RadioButton) findViewById(R.id.maleradio); 
female = (RadioButton) findViewById(R.id.femaleradio);
...// rest of the code