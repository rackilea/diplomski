@Override
protected void onCreate(Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    super.onCreate(savedInstanceState);
    setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, viewSelection));

ImageView imgView=(ImageView) findViewById(R.id.imgView);
imgView.setImageResource(R.drawable.img);

}