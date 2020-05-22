public class MainActivity extends Activity {

Draw draw;
Cal cal;
TextView textView;
RelativeLayout linearLayout;
Canvas canvas;
Paint paint;

public void onCreate(Bundle s) {
    super.onCreate(s);
    setContentView(R.layout.activity_main);

    linearLayout = (RelativeLayout) findViewById(R.id.t);
    cal = new Cal(this);
    cal.cal();

    textView = new TextView(getApplicationContext());
    textView.setText("" + cal.result);
    textView.setTextColor(Color.RED);

    draw = new Draw(this);

    LayoutParams layoutParams = new LayoutParams(200, 200);
    draw.setLayoutParams(layoutParams);

    linearLayout.addView(draw);
    linearLayout.addView(textView);
}}