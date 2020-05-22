FirstActivity

public class ViewCartActivity extends Activity {

String mGrandTotal;
@Override
protected void onCreate(Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    super.onCreate(savedInstanceState);
    setContentView(R.layout.viewcartactivity);

    ListView mLstView1 = (ListView) findViewById(R.id.listView1);
    TextView mTxtViewGrandTotal = (TextView) findViewById(R.id.mTxtViewGrandTotalValue);
    Button mBtnSubmit = (Button) findViewById(R.id.mBtnSubmit);

    ViewCartAdapter mViewCartAdpt = new ViewCartAdapter(
            ViewCartActivity.this);

    mLstView1.setAdapter(mViewCartAdpt);

    if (Constants.mItem_Detail.size() > 0) {
        Double mGTotal = Double.parseDouble(Constants.mItem_Detail.get(0)
                .get(SingleMenuItem.KEY_TOTAL));
        for (int i = 1; i < Constants.mItem_Detail.size(); i++) {
            mGTotal = mGTotal
                    + Double.parseDouble(Constants.mItem_Detail.get(i).get(
                            SingleMenuItem.KEY_TOTAL));
        }

        mGrandTotal = String.valueOf(mGTotal);
        mTxtViewGrandTotal.setText("$" + mGrandTotal);
    }

    mBtnSubmit.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub


             Intent i = new Intent(getApplicationContext(), CustomerLogin.class);
             i.putExtra("GrandTotal", mGrandTotal);
                startActivity(i);

        }
    });


SecondActivity

setContentView(R.layout.customer_login);

  Bundle b = getIntent().getExtras();
       String total = b.getString("GrandTotal");
    TextView grandtotal = (TextView) findViewById(R.id.grand_total);
     grandtotal.setText("Welcome ," + total );