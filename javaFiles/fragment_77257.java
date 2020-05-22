public void startGame(View v){

String randText = "";
String test = "10";
String test1 = "11";

Random randGen = new Random();

int rando = randGen.nextInt(10);
randText = Integer.toString(rando);

TextView RandomValue = (TextView) findViewById(R.id.randomValueTv);
RandomValue.setText(randText);

randomNumbersRbra();

TimerGame();

Button start = (Button)findViewById(R.id.startGameBtn);
start.setVisibility(View.INVISIBLE);

TextView go = (TextView)findViewById(R.id.tvGo);
go.setVisibility(View.VISIBLE);

Button btnTap1 = (Button)findViewById(R.id.tap1);
Button btnTap2 = (Button)findViewById(R.id.tap2);
Button btnTap3 = (Button)findViewById(R.id.tap3);
Button btnTap4 = (Button)findViewById(R.id.tap4);
Button btnTap5 = (Button)findViewById(R.id.tap5);
Button btnTap6 = (Button)findViewById(R.id.tap6);
Button btnTap7 = (Button)findViewById(R.id.tap7);
Button btnTap8 = (Button)findViewById(R.id.tap8);
Button btnTap9 = (Button)findViewById(R.id.tap9);

TextView tvtest = (TextView)findViewById(R.id.scoreTv);
tvtest.setText(test.toString());

//OnClickListener like below:
btnTap1.setOnClickListener(this);
btnTap2.setOnClickListener(this);

}

//And override method like below:
@Override
public void onClick(View view) {
    switch (view.getId()) {
    case R.id.tap1:
        // do something
        break;
    case R.id.tap2:
        //do something
        break;
    default:
        break;
    }
}