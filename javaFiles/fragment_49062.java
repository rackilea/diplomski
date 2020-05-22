`list=(ListView)findViewById(R.id.list);
adapter=new LazyAdapter(this, mStrings, mImages);
list.setAdapter(adapter);

list.setOnItemClickListener(new OnItemClickListener() {
public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3){

    Bundle bundle = new Bundle();
//instead of INCREMENT here use arg2 which gives you the position of the list item clciked.
    bundle.putString("selection", mPath[arg2]);

    Intent myIntent = new Intent(MainActivity.this, ShowFullSize.class);
    myIntent.putExtras(bundle);
    startActivityForResult(myIntent, 0); 
}
});