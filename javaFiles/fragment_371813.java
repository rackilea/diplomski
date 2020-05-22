BureauRateListing extends Activity{
 public String bs;
        private Intent i;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.rate_recycler_view);

            raterv = (RecyclerView) findViewById(R.id.raterv_rv);
            i = getIntent();

            bs = i.getStringExtra("buysell");
       }

       public string getbs(){
         return bs;
      }
}


CurrencySelectorAdapter extends ...{

    BureauRateListing mBureauRateListing;    // it's Activity

    CurrencySelectorAdapter (Activity activity){
        mBureauRateListing =activity;
    }
    .
    .
    .

    @Override
        public void onBindViewHolder(CurrencyViewHolder holder, int position) {
          String bs = mBureauRateListing.getbs();
          .
          .
          .
    }