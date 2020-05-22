protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_list_to);

etSearchTo=(EditText) findViewById(R.id.etSearchTo);
listViewTo=(ListView) findViewById(R.id.listViewTo);

initList();
listViewTo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
        intent.putExtra("To",v);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
});