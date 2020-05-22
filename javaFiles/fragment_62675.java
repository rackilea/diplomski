@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    final ViewGroup tes = (ViewGroup) findViewById(R.id.LL1);
    btnTes = (Button) findViewById(R.id.btnTes);

    btnTes.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(MainActivity.this, "KLIk", Toast.LENGTH_SHORT).show();
            final View extend = LayoutInflater.from(view.getContext()).inflate(R.layout.extend, tes, false);
            tes.addView(extend);

        }
    });
}