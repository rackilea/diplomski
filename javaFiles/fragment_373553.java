public class Page5 extends AppCompatActivity {

int score;

TextView scored;

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
requestWindowFeature(Window.FEATURE_NO_TITLE);
getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);;
setContentView(R.layout.activity_page5);
scored = (TextView) findViewById(R.id.score1);

Intent mintent = getIntent();
score = mintent.getIntExtra("score",0);
scored.setText(String.valueOf(score));

}
public void rightanswer(View view){

score = score + Integer.parseInt(scored.getText());
scored.setText(String.valueOf(score));
Intent intent = new Intent(this, Page6.class);
intent.putExtra("ta_score",score);
startActivity(intent);
ActivityOptions options = ActivityOptions.makeScaleUpAnimation(view, 0,
        0, view.getWidth(), view.getHeight());
startActivity(intent, options.toBundle());
}
}