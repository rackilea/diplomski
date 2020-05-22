HotOrNot entry2=new HotOrNot(this);
  entry2.open();  
  List<Map<String,String>> data2=entry2.getData();
  entry2.close();
  ListAdapter mSchedule = new SimpleAdapter(this, data2, R.layout.row,
               new String[] { "name", "address", "address2"},
               new int[] {R.id.rtextView1,R.id.rtextView2,R.id.rtextView3});
  lv.setAdapter(mSchedule);