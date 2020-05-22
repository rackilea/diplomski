protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_list_from);

listView=(ListView) findViewById(R.id.listviewFrom);
editText=(EditText) findViewById(R.id.etsearchFrom);

initList();
listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String v="";
        switch (position) {
            case 0:
                v = items[0];
                break;
            case 1:
                v = items[1];
                break;
            case 2:
                v = items[2];
                break;
            case 3:
                v = items[3];
                break;
            case 4:
                v = items[4];
                break;
            case 5:
                v = items[5];
                break;
        }
    Intent intent = new Intent();
        intent.putExtra("From",v);
        setResult(Activity.RESULT_OK, intent);
        finish();

    }
});