public class MainActivity extends AppCompatActivity {
    EditText number1, number2.....
    double ach1, ach2....

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeUi();

     .................
       ....................
     .................

    }


    private void initializeUi() {

        number1 = (EditText) findViewById(R.id.achieved1);
        number2 = (EditText) findViewById(R.id.achieved2);
        number3 = (EditText) findViewById(R.id.achieved3);
        number4 = (EditText) findViewById(R.id.achieved4);
        number5 = (EditText) findViewById(R.id.achieved5);
        number6 = (EditText) findViewById(R.id.achieved6);
        number7 = (EditText) findViewById(R.id.achieved7);
        number8 = (EditText) findViewById(R.id.achieved8);
        number9 = (EditText) findViewById(R.id.achieved9);
        number10 = (EditText) findViewById(R.id.achieved10);


        //Casting our button and the answer field

        answer = (EditText) findViewById(R.id.editText7);
        // setting up our % of grades part
        total0 = (EditText) findViewById(R.id.total0);
        total1 = (EditText) findViewById(R.id.total1);
        total2 = (EditText) findViewById(R.id.total2);
        total3 = (EditText) findViewById(R.id.total3);
        total4 = (EditText) findViewById(R.id.total4);
        total5 = (EditText) findViewById(R.id.total5);
        total6 = (EditText) findViewById(R.id.total6);
        total8 = (EditText) findViewById(R.id.total8);
        total9 = (EditText) findViewById(R.id.total9);




    }


    public void ons(View view) {


        ach1 = Integer.parseInt(number1.getText().toString());
        ach2 = Integer.parseInt(number2.getText().toString());
        ach3 = Integer.parseInt(number3.getText().toString());
        ach4 = Integer.parseInt(number4.getText().toString());
        ach5 = Integer.parseInt(number5.getText().toString());
        ach6 = Integer.parseInt(number6.getText().toString());
        ach7 = Integer.parseInt(number7.getText().toString());
        ach8 = Integer.parseInt(number8.getText().toString());
        ach9 = Integer.parseInt(number9.getText().toString());
        ach10 = Integer.parseInt(number10.getText().toString());

        tot1 = Integer.parseInt(total0.getText().toString());
        tot2 = Integer.parseInt(total1.getText().toString());
        tot3 = Integer.parseInt(total2.getText().toString());
        tot4 = Integer.parseInt(total3.getText().toString());
        tot5 = Integer.parseInt(total4.getText().toString());
        tot6 = Integer.parseInt(total5.getText().toString());
        tot7 = Integer.parseInt(total6.getText().toString());
        tot8 = Integer.parseInt(total7.getText().toString());
        tot9 = Integer.parseInt(total8.getText().toString());
        tot10 = Integer.parseInt(total9.getText().toString());

        double tots = (tot1 + tot2 + tot3 + tot4 + tot5 + tot6 + tot7 + tot8 + tot9 + tot10);
        double achst= ach1+ach2+ach3+ach4+ach5+ach6+ach7+ach8+ach9+ach10;

        double multi = achst / tots;
        String total2 = String.valueOf(multi);
        answer.setText(total2);

    }