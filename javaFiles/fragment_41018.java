private EditText cMoney;
private double currentMoney;
private EditText target;
private double theTarget;
private EditText bet;
private double minBet;
private boolean findRate;

@Override
protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_main);
  cMoney = (EditText) findViewById(R.id.money);
  currentMoney = Double.parseDouble(cMoney.getText().toString());
  target = (EditText) findViewById(R.id.target);
  theTarget = Double.parseDouble(target.getText().toString());
  bet = (EditText) findViewById(R.id.bet);
  minBet = Double.parseDouble(bet.getText().toString());
  findRate = calRate(currentMoney, theTarget, minBet);
}