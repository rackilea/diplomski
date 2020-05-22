`public class Final1 extends Activity {

Button btnRestart;
Button btnShare;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.final1);

    Bundle bundle = getIntent().getExtras();

    TextView textView = (TextView)findViewById(R.id.txt);
    textView.setText(bundle.getCharSequence("rg"));

    TextView textView1 = (TextView)findViewById(R.id.txt1);
    textView1.setText(bundle.getCharSequence("rg1"));

    TextView textView2 = (TextView)findViewById(R.id.txt2);
    textView2.setText(bundle.getCharSequence("rg2"));

    TextView textView3 = (TextView)findViewById(R.id.txt3);
    textView3.setText(bundle.getCharSequence("rg3"));

    TextView textView4 = (TextView)findViewById(R.id.txt4);
    textView4.setText(bundle.getCharSequence("rg4"));

    TextView textView5 = (TextView)findViewById(R.id.txt5);
    textView5.setText(bundle.getCharSequence("rg5"));

    TextView textView6 = (TextView)findViewById(R.id.txt6);
    textView6.setText(bundle.getCharSequence("rg6"));

    // NEW

TextView textviewResult = (TextView) findViewById(R.id.resultTV);
if(bundle.getString("rg").equals("C")){
        textviewResult.setText("It is C");
}
else if(bundle.getString("rg1").equals("A") || bundle.getString("rg2").equals("B")){
        textviewResult.setText("It is A or B");
}
else if(bundle.getString("rg1").equals("C") && bundle.getString("rg2").equals("D")){
        textviewResult.setText("It is C and D");
}
else if(!bundle.getString("rg1").equals("A")){
        textviewResult.setText("It is not A");
}
else {
    textviewResult.setText("Mhhh");
}

// END



    btnRestart = (Button)findViewById(R.id.restartBtn);

    btnRestart.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent in = new Intent(v.getContext(), Quiz.class);
            startActivityForResult(in, 0);
        }
    });

    btnShare = (Button)findViewById(R.id.btnShare);

    btnShare.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "check out this app";
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share via"));


        }
    });


  }

}`