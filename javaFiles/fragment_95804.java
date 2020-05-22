EditText player1field,player2field;
    Button startbutton;
    Intent startbuttonintent;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.single_options);
    setupActionBar();
    player1field = (EditText) findViewById(R.id.player1field);
    player2field = (EditText) findViewById(R.id.player2field);        
    startbutton.setOnClickListener(new View.OnClickListener()
    {
        @Override
        public void onClick(View v) {

            String player1name = player1field.getText().toString();
            String player2name = player2field.getText().toString();
            startbuttonintent = new Intent(this, Activity2.class);
            startbuttonintent.putExtra("PLAYER1NAME",player1name);
            startbuttonintent.putExtra("PLAYER2NAME",player2name);
            startActivity(startbuttonintent);
        }
    });
}