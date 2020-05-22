@Override
protected void onCreate(Bundle savedInstanceState) {
    String[] listM = getResources().getStringArray(R.array.listMenu1);
    super.onCreate(savedInstanceState);
    setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, listM));
}