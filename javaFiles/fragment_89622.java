listView=(ExpandableListView)findViewById(R.id.exp2);
initData();
listAdapter=new com.yeni.ExpandableListAdapter(this,listDataHeader,listHash);
listView.setAdapter(listAdapter);

super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);