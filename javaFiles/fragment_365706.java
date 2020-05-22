public class Activity1 extends ActionBarActivity {
    int cc1x, cc1y, cc2x, cc2y, ccdumx, ccdumy;
    EditText square1, square2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout1);

        square1 = (EditText) findViewById(R.id.square1);

        cc1x = 210;
        cc1y = 410;

        square1.setX(cc1x);
        square1.setY(cc1y);

        square2 = (EditText) findViewById(R.id.square2);

        cc2x = 310;
        cc2y = 410;

        square2.setX(cc2x);
        square2.setY(cc2y);

        ccdumx = 410;
        ccdumy = 410;
    }
//... rest of the code