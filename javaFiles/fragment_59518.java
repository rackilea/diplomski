public class MainActivity extends AppCompatActivity {
    int SelN=-1;
    Random Rand = new Random();
    TextView Hint;
    EditText GuessInput; 
    Button NewNumber; 
    Button Guess; 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Hint = (TextView)findViewById(R.id.textView);
       GuessInput = (EditText)findViewById(R.id.editText);
    NewNumber = (Button)findViewById(R.id.button);
    Guess = (Button)findViewById(R.id.button2);

        NewNumber.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                SelN = Rand.nextInt(100);
            }
        });
        Guess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Guessed = GuessInput.getText().toString();
                int Num = Integer.parseInt(Guessed);
                if(SelN == -1)Hint.setText("Error: Number not generated.");
                else if (Num < SelN)
                {
                    Hint.setText("Up");
                }
                else if(Num > SelN)
                {
                    Hint.setText("Down");
                }
                else
                {
                    Hint.setText("Good");
                    SelN=-1;
                }
            }
        });
    }
}