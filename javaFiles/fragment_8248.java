public class Main extends Activity {

    Context ctx;
    RelativeLayout rlayMainContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ctx = this;

        rlayMainContainer = (RelativeLayout) findViewById(R.id.mainContainer);
        Button one = (Button) findViewById(R.id.tvOne);
        Button three = (Button) findViewById(R.id.tvThree);


        // adding button two dynamically
        Button two = new Button(ctx);
        two.setText("hello");
        two.setId(12);

        RelativeLayout.LayoutParams lpSecond = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        lpSecond.addRule(RelativeLayout.CENTER_HORIZONTAL);
        lpSecond.addRule(RelativeLayout.BELOW, one.getId());

        rlayMainContainer.addView(two, lpSecond);

        //align button three below button two

        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) three
                .getLayoutParams();

        params.addRule(RelativeLayout.BELOW, two.getId());

        three.setLayoutParams(params);
    }
}