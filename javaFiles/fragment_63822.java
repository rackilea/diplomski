lv = (ListView) findViewById(R.id.listview);
lv.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, listview_array));
lv.setOnItemClickListener(new OnItemClickListener()
{
    public void onItemClick(AdapterView<?> arg0, View v, int position, long id)
    {
        AlertDialog.Builder adb = new AlertDialog.Builder(
        ListviewOnclickExample.this);
        adb.setTitle("ListView OnClick");
        adb.setMessage("Selected Item is = "+ lv.getItemAtPosition(position));
        adb.setPositiveButton("Ok", null);
        adb.show();                     
    }
 });