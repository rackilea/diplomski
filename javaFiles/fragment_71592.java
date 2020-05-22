public class MainActivity extends ActionBarActivity {

    private int viewLeftMargin;
    private int viewTopMargin;
    private int viewBottomMargin;
    private int viewRightMargin;
    private int lastMarginLeft;
    private int lastMarginRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView firstCircle = (ImageView) findViewById(R.id.firstCircle);
        final ImageView  secondCircle = (ImageView) findViewById(R.id.secondCircle);
        final TextView  textView1 = (TextView) findViewById(R.id.textView1);
        final TextView  textView2 = (TextView) findViewById(R.id.textView2);
        final TextView  textView3 = (TextView) findViewById(R.id.textView3);
        final TextView  textView4 = (TextView) findViewById(R.id.textView4);
        final TextView  textView5 = (TextView) findViewById(R.id.textView5);
        final TextView  textView6 = (TextView) findViewById(R.id.textView6);

        firstCircle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstCircleClick();
            }
        });

        secondCircle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secondCircleClick();
            }
        });



        RelativeLayout resultsBox = (RelativeLayout) findViewById(R.id.resultsBox);

        RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) resultsBox
                .getLayoutParams();
        lastMarginLeft = lParams.leftMargin;
        lastMarginRight = lParams.rightMargin;

        resultsBox.setOnTouchListener(
                new RelativeLayout.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        // TODO Auto-generated method stub
                        final int X = (int) event.getRawX();
                        final int Y = (int) event.getRawY();

                        switch (event.getAction() & MotionEvent.ACTION_MASK) {

                            case MotionEvent.ACTION_DOWN:
                                RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) v
                                        .getLayoutParams();
                                viewLeftMargin = X - lParams.leftMargin;
                                viewTopMargin = lParams.topMargin;
                                viewBottomMargin = lParams.bottomMargin;
                                viewRightMargin = X - lParams.rightMargin;
                                break;

                            case MotionEvent.ACTION_MOVE:
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) v
                                        .getLayoutParams();
                                layoutParams.rightMargin = X - viewRightMargin;
                                layoutParams.leftMargin = X - viewLeftMargin;
                                layoutParams.topMargin = viewTopMargin;
                                layoutParams.bottomMargin = viewBottomMargin;

                                if (layoutParams.leftMargin <= lastMarginLeft) {
                                    Log.d("ON_TOUCH", "Moving to left!");

                                    secondCircleClick();
                                } else {
                                    Log.d("ON_TOUCH", "Moving to right!");
                                    firstCircleClick();
                                }
                                break;
                        }
                        return true;
                    }
                }
        );

    }

    public void firstCircleClick(){
        textView1.setVisibility(View.VISIBLE);
        textView2.setVisibility(View.VISIBLE);
        textView3.setVisibility(View.VISIBLE);
        textView4.setVisibility(View.INVISIBLE);
        textView5.setVisibility(View.INVISIBLE);
        textView6.setVisibility(View.INVISIBLE);
    }

    public void secondCircleClick(){
        textView1.setVisibility(View.INVISIBLE);
        textView2.setVisibility(View.INVISIBLE);
        textView3.setVisibility(View.INVISIBLE);
        textView4.setVisibility(View.VISIBLE);
        textView5.setVisibility(View.VISIBLE);
        textView6.setVisibility(View.VISIBLE);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}