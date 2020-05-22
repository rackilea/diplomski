@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.acticity_history);
lv = (ListView) findViewById(R.id.listView);
mydb = new DatabaseHelper(this);

Cursor res = mydb.getAllData();
if(res.getCount() == 0)
{
    return;
}

else
{
  ArrayList<String> planetList = new ArrayList<String>();
  while(res.moveToNext()){
    planetList.add(res.getString(1));
    }

    listAdapter = new ArrayAdapter<String>(this, R.layout.simpleraw, planetList);

   lv.setAdapter(listAdapter);
  }
 } 
}