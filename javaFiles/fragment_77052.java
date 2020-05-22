public class SampleActivity extends Activity {
    LinearLayout lladdViews;
    Button count;
    int floor = 0;
    private int margincount = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_activity);
        lladdViews = (LinearLayout) findViewById(R.id.lladdViews);
        count = (Button) findViewById(R.id.count);
        count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addfloor();
            }
        });
    }


    public void addfloor() {

        Button myButton = new Button(this);
        myButton.setText("" + floor);
        margincount += 10;

        RelativeLayout ll = new RelativeLayout(this);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.addRule(RelativeLayout.ABOVE, R.id.floor0);
        lp.addRule(RelativeLayout.CENTER_HORIZONTAL);
        lp.bottomMargin = margincount;
        ll.addView(myButton, lp);
        lladdViews.addView(ll);
    }
    }