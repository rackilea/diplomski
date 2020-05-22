public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_main);
        ParseTitle parseTitle = new ParseTitle();
        parseTitle.execute();
avLoadingIndicatorView = (com.wang.avi.AVLoadingIndicatorView) findViewById(R.id.avi);
avLoadingIndicatorView.show();
arraylist = new ArrayList<HashMap<String, String>>();
database = FirebaseDatabase.getInstance();
ref1 = database.getReference("vacancies");
ref = ref1.child("jobsearch");
ref.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for (DataSnapshot ds : dataSnapshot.getChildren()) {
            String s_position = (String) ds.child("v_position").getValue();
            String s_employer = (String) ds.child("v_company").getValue();
            String s_posted = (String) ds.child("v_post").getValue();
            String s_link = (String) ds.child("v_url").getValue();

            HashMap<String, String> map = new HashMap<String, String>();
            map.put("POSITION", s_position);
            map.put("EMPLOYER", s_employer);
            map.put("POSTED", s_posted);
            map.put("LINK", s_link);
            map.put("TYPE", "IT");
            arraylist.add(map);
        }
        adapter = new ListViewAdapter(IT.this, arraylist);
        listView.setAdapter(adapter);
        avLoadingIndicatorView.hide();
        findViewById(android.R.id.content).setBackgroundColor(Color.TRANSPARENT);

    }
}