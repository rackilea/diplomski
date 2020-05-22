public class Popup_opis extends Activity implements OnClickListener{

TextView tvOpis;
int brojPoenaPrimljeno;
Button OK;
int counter;

 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.popup_opis);

        //Get intent
        Intent recIntent = getIntent();
         counter = recIntent.getIntExtra("counter");   //get counter variable from previous activity

OK.setOnClickListener(new OnClickListener() {

    public void onClick(View v) {
       counter++;

        Intent intent = new Intent(Popup_opis.this, ToploHladno.class);
        intent.putExtra("counter", counter); //SEND BACK COUNTER
        setResult(RESULT_OK, intent);  // send result
finish();