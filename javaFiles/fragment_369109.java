ListView lv;
    SearchView sv;


    String[] tagalog= new String[] {"alaala (png.)","araw (png.)","baliw (png.)","basura (png.)",
    "kaibigan (png.)","kakatuwa (pu.)", "kasunduan (png.)","dambuhala (png.)",
    "dulo (png.)","gawin (pd.)","guni-guni (png.)","hagdan (png.)","hintay (pd.)",
    "idlip (png.)","maganda (pu.)","masarap (pu.)", "matalino (pu.)"};



    ArrayAdapter<String> adapter;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


lv = (ListView) findViewById(R.id.listView1);
sv = (SearchView) findViewById(R.id.searchView1);

adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,tagalog);
lv.setAdapter(adapter);
lv.setOnItemClickListener(new OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String tagword =tagalog[position];


        String[] definition = getResources().getStringArray(R.array.definition);
        final String definitionlabel = definition[position];

        String[] cuyuno = getResources().getStringArray(R.array.cuyuno);
        final String cuyunodefinition = cuyuno[position];

        String[] english = getResources().getStringArray(R.array.english);
        final String englishdefinition = english[position];


        Intent intent = new Intent(getApplicationContext(), DefinitionActivity.class);
        intent.putExtra("tagword", tagword);
        intent.putExtra("definitionlabel", definitionlabel);
        intent.putExtra("cuyunodefinition",cuyunodefinition);
        intent.putExtra("englishdefinition", englishdefinition);
        // put position of the file 
        intent.putExtra("position", position);



        startActivity(intent);

    }
});


sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
    @Override
    public boolean onQueryTextSubmit(String text) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String text) {

        adapter.getFilter().filter(text);
        return false;
    }



});