@Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int    position, long arg3)  
    {

    EntryItem item = (EntryItem)items.get(position);
    Toast.makeText(this, "You clicked " + item.Designation , Toast.LENGTH_SHORT).show();
    if(position==1)
    {
      Intent intent = new Intent(Main_Activity.this, Android.class);
      startActivity(intent);
    }
    if(position==2)
    {
      Intent intent = new Intent(Main_Activity.this, Apple.class);
      startActivity(intent);
    }
}