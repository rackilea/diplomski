private ListClassFile rdActivity = null;
private LinearLayout recordContent = null;
private ListView lv;
....
@Overrid
protected void onCreate(...){
...
  recordContent = (LinearLayout) findViewById(R.id.recordContent);

    ...
    if( rdActivity == null )
        {
            rdActivity = new ListClassFile();
            lv = rdActivity.setListHandler(MainActivity.this);
            recordContent.addView(lv); 

           // rdActivity.setListHandler(MainActivity.this) it will return listview

        }
    }
    ...
}