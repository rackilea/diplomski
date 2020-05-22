listview.setOnItemClickListener(new OnItemClickListener() {
  @Override
  public void onItemClick(AdapterView<?> arg0,View arg1, int position, long arg3) {
    Intent n = null; 
    switch (position){
       case 0: 
         n = new Intent(getActivity(), Class0.class);
         break;
       case 1: 
         n = new Intent(getActivity(), Class1.class);
         break;
    }
    if(null!=n)
      startActivity(n);
  }
});