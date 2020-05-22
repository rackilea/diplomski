TextView p1name,p2name;
  public void onCreate(Bundle savedInstanceState)
{
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_3m);
  Bundle extras = getIntent().getExtras();
  String player1name = extras.getString("PLAYER1NAME");
  String player2name = extras.getString("PLAYER2NAME");
  p1name = (TextView) findViewById(R.id.p1name);
  p2name = (TextView) findViewById(R.id.p2name);
  p1name.setText(player1name);
  p2name.setText(player2name);
}