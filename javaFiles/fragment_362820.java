private SearchView search;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    search = (SearchView) findViewById(R.id.searchView1);

    search.setOnSearchClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent act = new Intent(getApplicationContext(), ResultActivity.class);
            startActivity(act);
        }
    });
}