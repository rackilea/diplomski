public class Main2Activity2 extends AppCompatActivity  {

RadioButton rb1;
RadioButton rb2;
RadioButton rb3;
RadioButton rb4;
TextView P1Name;
TextView P2Name;
TextView P3Name;
TextView P4Name;



    @Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main2);

        P1Name = (TextView) findViewById(R.id.PlayerName1);
        P2Name = (TextView) findViewById(R.id.PlayerName2);
        P3Name = (TextView) findViewById(R.id.PlayerName3);
        P4Name = (TextView) findViewById(R.id.PlayerName4);

        Intent intent = getIntent();
        String P1 = intent.getStringExtra("Player1Name");
        String P2 = intent.getStringExtra("Player2Name");
        String P3 = intent.getStringExtra("Player3Name");
        String P4 = intent.getStringExtra("Player4Name");
        P1Name.setText(P1);
        P2Name.setText(P2);
        P3Name.setText(P3);
        P4Name.setText(P4);


    }

}