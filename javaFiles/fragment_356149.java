Button btnBuy,btnSell;
@Override
 public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sales,
                container, false);
        btnBuy = (Button)rootView.findViewById(R.id.btn_buy);
        btnSell = (Button)rootView.findViewById(R.id.btn_sell); 
        btnBuy.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), Buy.class);
            startActivity(intent);      
            finish();
        }
        }); 
        return rootView;
 }